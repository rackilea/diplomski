public static void main(String[] args) throws Exception {
    if(args.size < 1) {
        throw new IllegalArgumentException("First arg is required");
    }
    String name = args[0];

    Injector injector = Guice.createInjector(new MyModule());
    IBFactory ibFactory = injector.getInstance(IBFactory.class);
    IB b = ibFactory.create(name)
    System.out.println(b.getA().getName());
}