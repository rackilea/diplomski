private void initGuicedWebservices(final String packageNamePrefix) 
        throws Exception {
    final Reflections reflections = new Reflections(packageNamePrefix);
    final Set<Class<?>> guiceManaged = 
        reflections.getTypesAnnotatedWith(GuiceManaged.class);
    for (final Class<?> clazz : guiceManaged) {
        doGuice(clazz);
    }
}

private void doGuice(final Class<?> clazz) throws Exception {
    final GuiceManaged guiceManagedAnnotation = 
        clazz.getAnnotation(GuiceManaged.class);

    final Injector injector = createInjector(guiceManagedAnnotation);

    final Object serviceObject = clazz.newInstance();
    injector.injectMembers(serviceObject);

    final String address = guiceManagedAnnotation.address();

    Endpoint.publish(address, serviceObject);
}

private Injector createInjector(final GuiceManaged guiceManagedAnnotation) 
        throws Exception {
    final Class<? extends Module>[] moduleClasses = 
        guiceManagedAnnotation.module();

    final List<Module> moduleInstances = new ArrayList<Module>();
    for (final Class<? extends Module> moduleClass : moduleClasses) {
        moduleInstances.add(moduleClass.newInstance());
    }

    return Guice.createInjector(moduleInstances);
}