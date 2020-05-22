public class MyProxy implements GenericI {

    Map<Category, GenericI> generics;

    public MyProxy() {
        Reflections reflections = new Reflections("your.base.package", new SubTypesScanner(), new TypeAnnotationsScanner());
        Set<Class<T extends MyInterface>> classes = reflections.getSubTypesOf(MyInterface.class);
        generics = new HashMap<Category, GenericI>();
        for (Class<T extends MyInterface> c : classes) {

            map.put(c.getAnnotation(MyAnnotation.class).value(), c.newInstance());
        }       
    }

    void method1(CATEGORY arg){

        map.get(arg).method1(arg);
    }   

}