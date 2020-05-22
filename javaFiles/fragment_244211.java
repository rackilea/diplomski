@Autowired
private ApplicationContext appContext;

Reflections r  = new Reflections(new MethodAnnotationsScanner(), "com.your.package");
Set<Method> methods = r.getMethodsAnnotatedWith(Controller.class);
for(Method m: methods){
    Controller controller = m.getAnnotation(Controller.class);
    for(EventType eventType: controller.value()){
        if(EventType.MESSAGE.equals(eventType)){
            String className = m.getDeclaringClass().getSimpleName();
            className = className.replaceFirst(className.substring(0,1), className.substring(0,1).toLowerCase());
            Object service = appContext.getBean(className);
            m.invoke(service, message);
        }
    }
}