package kuporific;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Main.class.getClassLoader().loadClass("kuporific.A");
    }
}