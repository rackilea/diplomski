class GeneratedInjector {
    public static void inject(Object instance) {
        if (instance instanceof Demo) {
            injectDemo((Demo) instance);
        }
    }
    public static void injectDemo(Demo demo) {
        demo.var = 1;
    }
}

class Injector {
    public static void inject(Object instance) {
        GeneratedInjector.inject(instance);
    }
}

class Demo {
    public int var;
    public int var2;

    public void call(){
        Injector.inject(this);
        System.out.println(var);
        System.out.println(var2);
    }
}

public class AnnotationDemo {
    public static void main(String[] args) {
        new Demo().call();
    }
}