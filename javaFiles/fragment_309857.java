Connection connection = factory.newConnection();
 Channel channel = connection.createChannel();
 channel.queueDeclare("myQueue", false, false, false, null);
 MyConsumer consumer = new MyConsumer(channel);
 String consumerTag = channel.basicConsume("myQueue", false, consumer);
 System.out.println("press any key to terminate");
 System.in.read();

 channel.basicCancel(consumerTag);<----- this stop listening
 channel.close(); <--- this close the channel and eventually all listening
 connection.close();<-- this close the connection and all channels