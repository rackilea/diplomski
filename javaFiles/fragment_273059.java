class MyBookAccount {
    //....
    public void sendMessage(MyBookAccount receiver, String message) {
       try{
         receiver.accept(this, message);
       }catch(MessageRejectedException e){
         //maybe put in queue to try again later, or log the date, time and reason of failure.
       }
    }
}