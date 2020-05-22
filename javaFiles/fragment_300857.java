MessageService.Client messageServiceClient;
public MessageService.Client getMessageService() {
   if(messageServiceClient!=null){ 
       return messageServiceClient;
   }
   TSocket socket = new TSocket("localhost", 9090, 3000);
   TTransport transport = new TFramedTransport(socket);
   try {
       transport.open();
   } catch (TTransportException e) {
       e.printStackTrace();
   }
   TProtocol protocol = new TBinaryProtocol(transport);
   messageServiceClient = new MessageService.Client(protocol); 
   return messageServiceClient;
}