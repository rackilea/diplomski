package net.codetojoy;

public class App {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("org.apache.commons.lang3.StringUtils");
        Object object = c.getConstructor().newInstance();
        System.out.println("object is : " + object);
    }
}