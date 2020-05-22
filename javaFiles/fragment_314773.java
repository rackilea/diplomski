public abstract class BSuper {

    private BSuper() {
        // initialize stuff
    }

    protected BSuper(some params) {
        this():
        // other init with parms
    }
}


public class B extends BSuper {

     public B(some other params) {
         super(some params);
     }
}


public class A extends B {

     public A() {
         super(some other params);
     }
}