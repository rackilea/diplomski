public void mymethod(2){
    if(counter==0)
        System.out.println("");
    else{                                       // <=== came into else block
        System.out.println("hello" + counter);  // <=== print "hello2"
        mymethod(--counter);                    // <=== invoke myMethod(1)
        System.out.println(" " +counter);
    }
}