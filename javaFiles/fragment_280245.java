@Bean
public SimpMessagingTemplate brokerMessagingTemplate() {
    SimpMessagingTemplate template = new SimpMessagingTemplate(brokerChannel());
    String prefix = getBrokerRegistry().getUserDestinationPrefix();
    if (prefix != null) {
        template.setUserDestinationPrefix(prefix);
    }