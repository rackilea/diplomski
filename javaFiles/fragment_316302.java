public Object createProxy(Class targetClass) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(targetClass);
    enhancer.setCallback(NoOp.INSTANCE);
    return enhancer.create();
   }