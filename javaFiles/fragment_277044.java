/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;

public class AutoConfiguringRepublishMessageRecoverer implements MessageRecoverer {

    public static final String X_EXCEPTION_STACKTRACE = "x-exception-stacktrace";

    public static final String X_EXCEPTION_MESSAGE = "x-exception-message";

    public static final String X_ORIGINAL_EXCHANGE = "x-original-exchange";

    public static final String X_ORIGINAL_ROUTING_KEY = "x-original-routingKey";

    private final Log logger = LogFactory.getLog(getClass());

    private final RabbitTemplate errorTemplate;

    private final RabbitAdmin admin;

    private final String deadLetterExchangeName = "DLX";

    private final DirectExchange deadletterExchange = new DirectExchange(this.deadLetterExchangeName);

    private boolean initialized;

    public AutoConfiguringRepublishMessageRecoverer(RabbitTemplate errorTemplate) {
        this.errorTemplate = errorTemplate;
        this.admin = new RabbitAdmin(errorTemplate.getConnectionFactory());
    }

    @Override
    public void recover(Message message, Throwable cause) {
        if (!this.initialized) {
            initialize();
        }
        Map<String, Object> headers = message.getMessageProperties().getHeaders();
        headers.put(X_EXCEPTION_STACKTRACE, getStackTraceAsString(cause));
        headers.put(X_EXCEPTION_MESSAGE, cause.getCause() != null ? cause.getCause().getMessage() : cause.getMessage());
        headers.put(X_ORIGINAL_EXCHANGE, message.getMessageProperties().getReceivedExchange());
        headers.put(X_ORIGINAL_ROUTING_KEY, message.getMessageProperties().getReceivedRoutingKey());

        String dlqName = message.getMessageProperties().getConsumerQueue() + ".dlq";
        if (this.admin.getQueueProperties(dlqName) == null) {
            bindDlq(dlqName);
        }
        this.errorTemplate.send(this.deadLetterExchangeName, dlqName, message);
        if (this.logger.isWarnEnabled()) {
            this.logger.warn("Republishing failed message to " + dlqName);
        }
    }

    private void initialize() {
        this.admin.declareExchange(this.deadletterExchange);
        this.initialized = true;
    }

    private void bindDlq(String dlqName) {
        Queue dlq = new Queue(dlqName);
        this.admin.declareQueue(dlq);
        this.admin.declareBinding(BindingBuilder.bind(dlq).to(this.deadletterExchange).with(dlqName));
    }

    private String getStackTraceAsString(Throwable cause) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        cause.printStackTrace(printWriter);
        return stringWriter.getBuffer().toString();
    }

}