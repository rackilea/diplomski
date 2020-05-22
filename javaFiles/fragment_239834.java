public void mymethod(2){
    if(counter==0)
        System.out.println("");
    else{                                       
        System.out.println("hello" + counter);  
        mymethod(--counter);                    // <=== this point invoked myMethod(1)
        System.out.println(" " +counter);       // <=== continue from here (print " " + 1)
    }
} // <=== exit method (goes back to last point where this myMethod(2) was called