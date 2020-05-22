@Override
protected Factory<?> createValueFactory(Parameter parameter) {
     Class<?> paramType = parameter.getRawType();
     TenantDatastore annotation = parameter.getAnnotation(TenantDatastore.class);
     if (annotation != null && paramType.isAssignableFrom(Datastore.class)) {
         return getFactory();
     }
     return null;
}

private Factory<Object> getFactory() {
    return new Factory<Object>() {

        @Context
        Datastore datastore;

        @Override
        public Object provide() {
            return datastore;
        }

        @Override
        public void dispose(Object t) {}
    };
}