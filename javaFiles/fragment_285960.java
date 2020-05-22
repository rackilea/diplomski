public void executeProperControllerMethodBasedOnId() {
    Set<Class<?>> classes = new org.reflections.Reflections("org.conffusion")
            .getTypesAnnotatedWith(MessageType.class);
    System.out.println("found classes " + classes.size());
    for (Class<?> c : classes) {
        for (Method m : c.getMethods()) {
            try {
                if (m.isAnnotationPresent(MessageId.class)) {
                    MessageId mid = m.getAnnotation(MessageId.class);
                        Object o = c.newInstance();
                    if (mid.id() == id)
                        m.invoke(o);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}