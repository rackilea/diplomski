public class Test {
    class Pet {}

    class Dog extends Pet {}

    public static void main(String[] args) throws Exception {
        Class<Dog> dogClass = Dog.class;
        Dog dog = dogClass.newInstance();
    }
}