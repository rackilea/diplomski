@Component
public class MyProxy implements GenericI {

    @Autoriwed // If spring
    List<GenericI> generics; 

    @Inject @Any // If CDI
    private Instance<GenericI> services;

    Map<Category, GenericI> generics;

    @PostConstruct
    void makeMap() {
        generics = new HashMap<>();
        for (GenericI component : generics) {
            generics.put(
                component.getClass().getAnnotation(MyAnnotation.class).value(),
                component);
        }
    }

    void method1(CATEGORY arg){

        map.get(arg).method1(arg);
    }   

}