instanceOfClassRaisingCallback.setEventHappendedObserver(new EventHappened{
     @Override
     void callBack(int arg1, String arg2){
          doStuffWithArgs(arg1,arg2);
     }
   )};