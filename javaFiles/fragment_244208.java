for(Method method: Service.class.getDeclaredMethods()){
    Controller annotation = m.getAnnotation(Controller.class);
    for(EventType event: annotation.events()){
        if(event.equals(yourActiveEventType)){
            method.invoke(service, message);
        }
        return ...
    }
}