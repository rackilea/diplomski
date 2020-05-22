package net.lenthe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "myMessageTopic", containerFactory = "topicJmsListenerContainerFactory") 
    public void processTopicMessage(String content) {
        logger.info("Received topic message.  Content is " + content);
    }

    @JmsListener(destination = "myMessageQueue") 
    public void processQueueMessage(String content) {
        logger.info("Received queue message.  Content is " + content);
    }
}