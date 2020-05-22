ClassPool pool = ClassPool.getDefault();
CtClass factoryClass = pool.getCtClass("ServiceFactory");
CtConstructor constructor = factoryClass.getDeclaredConstructor(null);
String setMockStatement = String.format("service = new %s();",
        MockServiceImpl.class.getCanonicalName());
constructor.insertAfter(setMockStatement);
factoryClass.toClass();
new ServiceFactory().getService().say();