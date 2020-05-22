void firstMethod(){
      if (secondMethod()) return;
      Log.d("log","hello!"); 
  }

  boolean secondMethod(){
      return true; // Than, I dont want to see log message "hello!".
  }