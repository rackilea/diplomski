synchronized (someObject){
  try {
     someObject.wait();
     result = responseFromServer();
   } catch (InterruptedException e) {
        //when the object is interrupted
   }
}