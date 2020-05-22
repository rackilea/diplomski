...
private static ApplicationContext context;

public static void main(final String[] args) {

    context = new AnnotationConfigApplicationContext(DispatcherConfiguration.class);

    SpringApplication.run(DispatcherApplication.class, args);
}

public static ApplicationContext getApplicationContext() {
    return context;
}