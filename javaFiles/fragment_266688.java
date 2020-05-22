public class Cat { 
    private static int myval;

    public String meow() {
        return "Meow!";
    }
}

public class MainClass {
    public static void main(String[] argsv) {
        Cat cat = new Cat();
        System.out.println(cat.meow());
    }
}