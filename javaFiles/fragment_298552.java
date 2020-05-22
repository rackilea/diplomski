class Foo {

    static void bar() {
        Runnable r = new Runnable() {
            public void run() {};
        };

        System.out.println(r.getClass());
    }
}