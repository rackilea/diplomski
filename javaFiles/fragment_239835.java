public void mymethod(3){
    if(counter==0)
        System.out.println("");
    else{                                       
        System.out.println("hello" + counter);  
        mymethod(--counter);                    // <=== this point invoked myMethod(2)
        System.out.println(" " +counter);       // <=== continue from here (print " " + 2)
    }
} // <=== exit method (goes back to last point where this myMethod(3) was called