public static void main(String[] args) {

    Injector injector = Guice.createInjector(b -> {
        b.bind(ApplicationContext.class).toProvider(() -> {
            // construct and configure application context
            ApplicationContext ctx = new ApplicationContext();
            ctx.setSomething(args[0]);
            ctx.setSomethingElse(args[1]);
            return ctx;
        }).in(Singleton.class);
    });

}