public Generic() {
    Class class1 = getClass();
    Type genericSuperclass = null;
    for(;;) {
        genericSuperclass = class1.getGenericSuperclass();
        if(genericSuperclass instanceof ParameterizedType)
            break;
        class1 = class1.getSuperclass();
    }
    ParameterizedType genericSuperclass_ = (ParameterizedType) genericSuperclass;
    entityClass = ((Class) ((Class) genericSuperclass_.getActualTypeArguments()[0]));
}