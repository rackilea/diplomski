public static void handleGracefully() throws FooException {
        try {
            hello();
        } catch (BarException be) {
            System.out.println("Hello world");
            throw new FooException("BLEEEEH");
        }
    }