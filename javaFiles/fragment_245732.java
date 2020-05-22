Sender sender = new Sender (SENDER_API_CODE);

Message message = new Message.Builder ()
    .collapseKey ("1")
    .timeToLive (2419200)
    .delayWhileIdle (false)
    .addData ("message", "example message")
    .build ();

result = sender.send (message, reGid, sendCount);