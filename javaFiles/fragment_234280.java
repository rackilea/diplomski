public void run(){

    while( true ){

         Thread.sleep( 1000 ); //1s
         if( lastMessage != null ){
             doSomethingWith( lastMessage );
             lastMessage = null;
         }
    }
}