ProxyFactory factory = new ProxyFactory();
factory.setSuperclass(Dog.class);
factory.setFilter(
    new MethodFilter() {
        @Override
        public boolean isHandled(Method method) {
            return Modifier.isAbstract(method.getModifiers());
        }
    }
);

MethodHandler handler = new MethodHandler() {
    @Override
    public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
        System.out.println("Handling " + thisMethod + " via the method handler");
        return null;
    }
};

Dog dog = (Dog) factory.create(new Class<?>[0], new Object[0], handler);
dog.bark();
dog.fetch();