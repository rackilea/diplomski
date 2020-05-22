public void subscribe(EventType eventType, AbstractEventConsumer consumer) {
    Assert.notNull(eventType);
    Assert.notNull(eventType.toString());
    Assert.isTrue(!eventType.toString().isEmpty());

    Queue queue=new Queue("", false, true, true);
    Map<String, Exchange> beanMap=context.getBeansOfType(Exchange.class);
    if(beanMap!=null&&!beanMap.isEmpty()){
        Exchange exchange=null;
        boolean found=false;
        for(String key : beanMap.keySet()) {
            exchange=beanMap.get(key);
            if(getExchangeName(eventType.toString()).equals(exchange.getName())){
                found=true;
                break;
            }
        }
        if(found){
            String queueName=amqpAdmin.declareQueue(queue);
            amqpAdmin.declareBinding(new Binding(queueName, Binding.DestinationType.QUEUE, exchange.getName(), "", null));
            SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
            container.setConnectionFactory(connectionFactory);
            container.setQueueNames(queueName);
            container.setMessageListener(new MessageListenerAdapter(consumer));
            container.start();
        }else{
            //TODO
        }
    }
}