<from uri="rabbitmq://localhost/youexchange?queue=yourq1&amp;
            exchangeType=topic&amp;
            routingKey=user.reg.*&amp;
            deadLetterExchange=dead.msgs&amp;
            deadLetterExchangeType=topic&amp;
            deadLetterRoutingKey=dead.letters&amp;
            deadLetterQueue=dead.letters&amp;
            autoAck=false&amp;
            autoDelete=false"/>

          <!--We can use onException to make camel to retry, and after that, dead letter queue are the fallback-->
        <onException useOriginalMessage="true">
            <exception>java.lang.Exception</exception>
            <redeliveryPolicy asyncDelayedRedelivery="true" maximumRedeliveries="3" redeliveryDelay="5000"/>
        </onException>