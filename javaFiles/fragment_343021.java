package p2;

import p1.demo1;

public class demo2 extends demo1 {

    protected int foo( int a, int b ) {
        return (new demo22()).fun2(a, b);
    }

    protected class demo22 extends demo12 {
        protected int fun2( int a, int b ) {
            return super.fun2(a, b);
        }
    }

    public static void main( String[] args ) {
        (new demo2()).foo(2, 3);
    }
}