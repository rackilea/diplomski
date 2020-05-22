class MyBookAccount {
  private final List<String> receivedMessages = new ArrayList<>();
  ...
  public void accept(MyBookAccount sender, String message){
      if(!loggedIn){
        throw new MessageRejectedException("not online");
      }
      receivedMessages.add(message);
      //you can also have a list of Objects that are like 
      //class Message{String senderName; String message; Date reveived; /*...*/}
      //trigger UI update or fire property changed event that announces the list of messages has changed
  }

  public Optional<String> getLastMessage(){
     return receivedMessages.isEmpty() ? Optional.empty() 
             : Optional.of(receivedMessages.get(receivedMessages.size()-1));
  }