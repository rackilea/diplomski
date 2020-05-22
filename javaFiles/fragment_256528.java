package com.mycompany.data;

public class Application {
    public static void main(String[] args) throws Exception {
        for (Class<?> clazz : new Class[] { Application.class, Cat.class, Dog.class, Gender.class, Animal.class }) {
            String implementsYesNo = " does not implement";
            for (Class<?> iface : clazz.getInterfaces()) {
                if (iface == Secure.class) {
                    implementsYesNo = " implements";
                    Object instance = clazz.newInstance();
                    clazz.getMethod("doSomething").invoke(instance);
                    break;
                }
            }
            System.out.println(clazz.getSimpleName() + implementsYesNo + " interface Secure\n");
        }
    }
}