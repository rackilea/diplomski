Genson genson = Genson.Builder().with(new BeanMutatorAccessorResolver.BaseResolver() {
        @Override
        public Trilean isMutator(Method method, Class<?> fromClass) {
            // if method starts with setXXX and return type same as method.getDeclaringClass
            return Trilean.TRUE;
            // else return Tilean.UNKNOWN genson will use its built-in resolvers
        }
    }).create();