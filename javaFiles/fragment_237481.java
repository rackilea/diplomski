public static void setSomeClass(SomeClass = someClass1) {

     synchronized(this){

          if(isThreadStarted) {
            someClass = someClass1;
          }
    }
}