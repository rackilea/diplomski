package test;

import java.util.Collections;
import org.springframework.cloud.aws.messaging.listener.QueueMessageHandler;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

public class CustomQueueMessageHandler extends QueueMessageHandler {

  public void init(Object handler) {
    detectHandlerMethods(handler);
  }
}