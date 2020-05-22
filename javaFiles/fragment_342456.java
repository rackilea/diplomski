@Override
 @JmsListener(destination = "queue")
 public void processQueue(ResponseType response){

        //process message as you want
 }