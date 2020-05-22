@Bean
@ServiceActivator(inputChannel = "someChannel")
public MessageHandler filter() {
    MessageFilter filter = new MessageFilter(selector());
    filter.setOutputChannelName("outChannel");
    return filter;
}

@Bean
public MessageSelector selector() {
    return new ExpressionEvaluatingSelector("#jsonPath(...) matches ...");
}