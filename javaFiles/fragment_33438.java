public void onLocaitonChanged(Location location){

  // this if statement may achieve the condition many times
  if(somethingHappened){

       if (!isAlreadyCalled){   
           callAMethodOnce();// this method is called once even if the condition achieved again
           isAlreadyCalled = true;
       }
  }

}