public void clearMessages(String queueName) throws TibjmsAdminException, TibjmsAdminInvalidNameException{
    TibjmsAdmin jmsAdmin = new TibjmsAdmin("tcp://localhost:7222", "admin", "admin");
    jmsAdmin.purgeQueue(queueName);
    // alternatively purge all queues:
    // jmsAdmin.purgeQueues(">");
}