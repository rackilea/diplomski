@Bean(name="persistenceListenerAdapter")
MessageListenerAdapter persistenceListenerAdapter(PersistenceListener persistenceListener) {
    return new MessageListenerAdapter(persistenceListener, "receiveMessage");
}



@Bean(name="webListenerAdapter")
MessageListenerAdapter webAppListenerAdapter(WebAppListener webAppListener) {
    return new MessageListenerAdapter(webAppListener, "receiveMessage");
}