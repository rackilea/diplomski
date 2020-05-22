package myPackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("myPackage.Test$a");
            Constructor con = clazz.getConstructor(String.class);
            Object instanceOfA = con.newInstance("A value");
            Field bField = clazz.getField("b");
            Object instanceOfB = bField.get(instanceOfA);
            Method printBMethod = instanceOfB.getClass().getMethod("printB");
            printBMethod.invoke(instanceOfB);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchFieldException ex) {
            ex.printStackTrace();
        }
    }

    public static class a {

        public B b;

        public a(String s) {
            b = new B(s);
        }
    }

    public static class B {

        String s;

        public B(String s) {
            this.s = s;
        }

        public void printB() {
            System.out.println(this.s);
        }

    }
}