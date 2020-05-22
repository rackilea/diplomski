rabbitTemplate.convertAndSend("Hello World!", message -> {
  MessageProperties properties = MessagePropertiesBuilder.newInstance()
                                                         .setPriority(0)
                                                         .build();
  return MessageBuilder.fromMessage(message)
                       .andProperties(properties)
                       .build();
});