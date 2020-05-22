(psuedo code - in one thread, do the following when you need to request data over JMS)
myMessage = session.createTextMessage("My nice request");
messageProducer.send(myMessage); // using some previously setup producer
// commit if needed

mc = session.createConsumer(queue,"JMSCorrelationId='"+myMessage.getMessageId()+"'");
responseMessage = mc.receive(TIMEOUT);
if( responseMessage != null){
  //got OUR response data
}
// close down consumer here.