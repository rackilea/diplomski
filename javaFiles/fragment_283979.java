class A{
    static void doFoo(X x){
        x.foo();
    }
}

class X{
    X(){
        A.doFoo(this); // ouch, don't do this!
    }

    void foo(){
        System.out.println("Leaking this seems to work!");
    }

}

class Y extends X {
     PrintStream stream;

     Y(){
         this.stream = System.out;
     }

     @Overload // Polymorphism ruins everything!
     void foo(){
         // NullPointerException; stream not yet initialized 
         stream.println("Leaking + Polymorphism == NPE");      
     }

}