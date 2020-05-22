public void mymethod(1){
    if(counter==0)
        System.out.println("");
    else{                                       
        System.out.println("hello" + counter);  
        mymethod(--counter);                    // <=== this point invoked myMethod(0)
        System.out.println(" " +counter);       // <=== continue from here (print " " + 0)
    }
} // <=== exit method (goes back to last point where this myMethod(1) was called