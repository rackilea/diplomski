Sender sender = new Sender(apiKey);
Message message = new Message.Builder()
    .delayWhileIdle(true)
    .addData("key1", "value1")
    .addData("key2", "value2")
    .build();
Result result = sender.send(message, registrationId, numOfRetries);