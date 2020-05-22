final Callable<String> task = () -> {
   try{    
       if( !Globals.serviceUnavailable ) callServiceToRemove(builder,userId);
   }
   catch( ServiceUnavailableException e ){ //Or whatever your exception is
       Globals.serviceUnavailable = true; //Notify the remaining tasks that the service is unavailable.
   }

}