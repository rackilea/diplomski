public void mymethod(0){
    if(counter==0)                              // <=== if-condition is true
        System.out.println("");                 // <=== print newline
    else{                                       
        System.out.println("hello" + counter);  
        mymethod(--counter);                    
        System.out.println(" " +counter);
    }
} // <=== exit method (goes back to last point where this myMethod(0) was callled)