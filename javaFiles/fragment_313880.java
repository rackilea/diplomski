class Bar {
    public static void foo(Pritable p) {
        p.sysout();
        p.displayName();
    }
}

class Test {
    public static final void main(String[] args) {
        Bar.foo(new Parent());
    }
}