ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection con = factory.newConnection();
        rabbitChannel = con.createChannel();
GetResponse response = rabbitChannel.basicGet(QUEUE_NAME, BOOLEAN_NOACK);
if(response != null){
String body = new String(responseQuestion.getBody());
// do whatever you want to do here
}
else{
rabbitChannel.queueDelete(QUEUE_NAME);
}