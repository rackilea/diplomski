public class Person {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("My name is %s and I am %d years old", name, age);
    }
}


public class Main {
    public static void main(String[] args) {
        Person me = new Person("Niels", 20);
        System.out.println(me);
    }
}