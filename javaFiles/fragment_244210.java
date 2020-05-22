Service service = ...;
Message message = ...;

Set<Method> methods = 
        ReflectionUtils.getMethods(Service.class, ReflectionUtils.withAnnotation(Controller.class),ReflectionUtils.withParametersAssignableTo(Message.class));

for(Method m: methods){
    Controller controller = m.getAnnotation(Controller.class);
    for(EventType eventType: controller.value()){
        if(EventType.MESSAGE.equals(eventType)){
            m.invoke(service, message);
        }
    }
}