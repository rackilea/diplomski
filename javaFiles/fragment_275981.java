ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

 ConnectionFactory connectionFactory = ctx.getBean(ConnectionFactory.class);
 RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
 AbstractMessageListenerContainer container = startListening(rabbitAdmin, rabbitAdmin.declareQueue(),
         new DirectExchange("amq.direct"), "testRoute", message -> {
             System.out.println(new String(message.getBody()));
         });