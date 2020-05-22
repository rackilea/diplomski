public class A {
    ... 
    public static void doStuff(Class<? extends B> clazz) {
        try {
            C obj = clazz.newInstance();
            obj.randomize();
        } catch (InstantiationException | IllegalAccessException e) {
        }       
    }

}

abstract class B {
    abstract void randomize();
}

class C extends B {
    ...
    public void randomize() {
        System.out.println("works");
    }
}