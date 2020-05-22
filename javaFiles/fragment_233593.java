abstract class Compound { }

class Compound1 extends Compound { }

abstract class CompoundService<T extends Compound> {
    ...
}

class Compound1Service extends CompoundService<Compound1> {
    ...
}

public class Test {

    static Map<Class<? extends Compound>, CompoundService<? extends Compound>> serviceMap = new HashMap<Class<? extends Compound>, CompoundService<? extends Compound>>();

    public static <T extends Compound> void main(String[] args) {
        serviceMap.put(Compound1.class, new Compound1Service());
        CompoundService<Compound1> service = getServiceFromMap(Compound1.class);
        System.out.println(service.getClass());
    }

    public static <T extends Compound> CompoundService<T> getServiceFromMap(Class<T> clazz) {
        return(CompoundService<T>)serviceMap.get(clazz);
    }

}