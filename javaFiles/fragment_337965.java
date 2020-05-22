try{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);



    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("xx.xx.xx.xx");

    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    String message = "Hello Java!";
    channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
    System.out.println(" [x] Sent '" + message + "'");

    channel.close();
    connection.close();
} catch(IOException e) {
    e.printStackTrace() //Or log it to a file, or clean up resources
}