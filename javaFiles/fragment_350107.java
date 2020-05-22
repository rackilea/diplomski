public AutowiredAnnotationBeanPostProcessor()
{
    this.autowiredAnnotationTypes.add(Autowired.class);
    this.autowiredAnnotationTypes.add(Value.class);
    ClassLoader cl = AutowiredAnnotationBeanPostProcessor.class.getClassLoader();
    try {
        this.autowiredAnnotationTypes.add(cl.loadClass("javax.inject.Inject"));
        this.logger.info("JSR-330 'javax.inject.Inject' annotation found and supported for autowiring");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
}