GroovySystem.getMetaClassRegistry().setMetaClassCreationHandle(new ExpandoMetaClassCreationHandle() {

    @Override
    protected MetaClass createNormalMetaClass(Class theClass, MetaClassRegistry registry) {

        final List<Method> propertyMethods = new ArrayList<>();
        for (Method method : theClass.getDeclaredMethods()) {
            if (method.getReturnType() == TheMethodReturnTypeYouCareAbout.class) {
                propertyMethods.add(method);
            }
        }

        final MetaClass mc;
        if (propertyMethods.isEmpty() == false) {

            final ExpandoMetaClass expando = new ExpandoMetaClass(theClass, true, true);
            for (Method mm : propertyMethods) {
                final ClassInfo ci = ClassInfo.getClassInfo(mm.getDeclaringClass());
                expando.addMetaMethod(new MetaMethod() {

                    @Override
                    public int getModifiers() {
                        return mm.getModifiers();
                    }

                    @Override
                    public String getName() {
                        return mm.getName();
                    }

                    @Override
                    public Class getReturnType() {
                        return mm.getReturnType();
                    }

                    @Override
                    public CachedClass getDeclaringClass() {
                        return ci.getCachedClass();
                    }

                    @Override
                    protected Class[] getPT() {
                        return mm.getParameterTypes();
                    }

                    @Override
                    public Object invoke(Object object, Object[] arguments) {
                        try {
                            final Object value = mm.invoke(object, arguments);
                            // Do whatever you need with the value.
                            return value;
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
            }

            mc = expando;
        } else if (GeneratedClosure.class.isAssignableFrom(theClass)) {
            mc = new ClosureMetaClass(registry, theClass);
        } else {
            mc = new MetaClassImpl(registry, theClass);
        }

        return mc;
    }
});