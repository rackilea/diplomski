class MessageGroup implements Runnable {
    String type;
    String List<Message> messageList;

    @Override
    public void run() {
      for(Message message : MessageList) {
         message.process();
      }
    }
}