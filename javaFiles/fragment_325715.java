class HelloAnonymous {
    @FunctionalInterface
    interface Hello {
        String say();
    }

    // old school
    Hello hello(String world) {
        return new Hello() {
            public String say() {
                return world;
            }
        };
    }

    // with lambda notation
    Hello alsoHello(String world) {
        return () -> {
            return world;
        };
    }

    public static void main(String... none) {
        System.out.println(new HelloAnonymous().hello("world").say());
        System.out.println(new HelloAnonymous().alsoHello("world").say());
    }
}