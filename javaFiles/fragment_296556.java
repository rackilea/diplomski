class Outer {

    /*synthetic*/ static int access$000(Outer x0) {
        return x0.a;
    }

    Outer() {
        super();
    }
    private int a = 10;

    public void outerMethod() {
        int x = 30;
        /*synthetic*/ {
        }
        ;
        Outer$1Inner inner = new Outer$1Inner(this, x);
        inner.innerMethod();
    }
}

class Outer$1Inner {
    /*synthetic*/ final Outer this$0;
    /*synthetic*/ final int val$x;

    Outer$1Inner(final Outer this$0, /*synthetic*/ final int val$x) {
        // Notice the synthetic references to the surrounding Outer object
        // and to the x local variable
        // Both become fields of Inner

        this.this$0 = this$0;
        this.val$x = val$x;
        super();
    }
    private int b = 20;

    public void innerMethod() {
        System.out.println("The Value of a is: " + Outer.access$000(this$0));
        System.out.println("The Value of b is: " + b);
        System.out.println("The Value of x is: " + val$x);
    }
}