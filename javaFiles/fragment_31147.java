for (String queueName : server.getActiveMQServerControl().getQueueNames()) {
   Queue queue = server.locateQueue(SimpleString.toSimpleString(queueName));
   if (queue != null) {
      queue.deleteAllReferences();
   }
}