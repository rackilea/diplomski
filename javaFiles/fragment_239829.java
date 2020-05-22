public void mymethod(3){
    if(counter==0)
        System.out.println("");
    else{                                       // <=== came into else block
        System.out.println("hello" + counter);  // <=== print "hello3"
        mymethod(--counter);                    // <=== invoke myMethod(2)
        System.out.println(" " +counter);
    }
}