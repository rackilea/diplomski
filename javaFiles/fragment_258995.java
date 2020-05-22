public <S> GenericBuilder<T> with(String propertyName, S value) {
    try {
        String target = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        for (Method m : clazz.getMethods()) {
            if (target.equals(m.getName())) {
                Class<?>[] params = m.getParameterTypes();
                if (params.length == 1) {
                    m.invoke(bean, value);
                    break;
                }
            }
        }
    } catch (InvocationTargetException | IllegalAccessException e) {
        e.printStackTrace();
    }
    return this;
}