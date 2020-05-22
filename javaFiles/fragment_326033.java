class A { 
    static { 
        System.loadLibrary(“A”); 
    }

    C c;
} 

class C { 
     static { 
         System.loadLibrary(“C”); 
     }
}