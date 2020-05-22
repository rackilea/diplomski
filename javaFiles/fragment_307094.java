Reflections reflections = new Reflections("your.base.package", new SubTypesScanner(), new TypeAnnotationsScanner());
Set<Class<T extends MyInterface>> classes = reflections.getSubTypesOf(MyInterface.class);

for (Class<T extends MyInterface> c : classes) {

     check if c is the rigth implementation!.
}