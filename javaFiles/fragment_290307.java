package com.stackoverflow.so21821751;

public class Test {
    interface ParentInterface {
        void someMethod();
    }

    static enum ChildEnum1 implements ParentInterface {
        FOO, BAR, LOL;

        @Override
        public void someMethod() {
            // something
        }
    }

    static enum ChildEnum2 implements ParentInterface {
        FOO, BAR;

        @Override
        public void someMethod() {
            // something
        }
    }

    public static void main(final String[] args) {
        foo(ChildEnum1.BAR); // 3
        foo(ChildEnum2.FOO); // 2
    }

    private static void foo(final ParentInterface i) {
        System.out.println(i.getClass().getEnumConstants().length);
    }
}