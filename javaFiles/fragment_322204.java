SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
....
container.setMessageListener(new MessageListener() {

   public void onMessage(Message message) {
       sendMessageToFlumeChannel(message);
   }

});