class HelloAnonymous {
    interface Hello {
        String say();
    }

    Hello hello(String world) {
        return new Hello() {
            public String say() {
                return world;
            }
        };
    }

    public static void main(String... none) {
        System.out.println(new HelloAnonymous().hello("world").say());
        // prints 'world'
    }
}