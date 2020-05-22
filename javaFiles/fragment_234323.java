package package2;

import package1.Outer;
import java.lang.reflect.Constructor;

public class Test {
    public static void main(String[] args) throws Exception {

        Outer outerObject = new Outer();

        Class<?> innerClazz = Class.forName("package1.Outer$Inner");

        // constructor of inner class as first argument need instance of
        // Outer class, so we need to select such constructor
        Constructor<?> constructor = innerClazz.getDeclaredConstructor(Outer.class);

        //we need to make constructor accessible 
        constructor.setAccessible(true);

        //and pass instance of Outer class as first argument
        Object o = constructor.newInstance(outerObject);

        System.out.println("we created object of class: "+o.getClass().getName());

    }
}