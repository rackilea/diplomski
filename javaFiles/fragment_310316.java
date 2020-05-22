final Class clazz = Whitebox.getInnerClassType(parentClass.getClass(), "InnerClassName");
final Constructor constructor = 
     Whitebox.getConstructor(clazz, paretnClass.getClass(), AnInterface.class);
     // Here -----------------------^

statusPage = constructor.newInstance(parentClass, interfaceMockObject);
// And pass the parent instance -----^