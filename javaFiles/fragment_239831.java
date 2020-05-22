public void mymethod(1){
    if(counter==0)
        System.out.println("");
    else{                                       // <=== came into else block
        System.out.println("hello" + counter);  // <=== print "hello1"
        mymethod(--counter);                    // <=== invoke myMethod(0)
        System.out.println(" " +counter);
    }
}