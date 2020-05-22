class Animal {
    public String name = "Bello";

}

public class Cat extends Animal {
    public String name = "Kitty";

    Cat(){
        System.out.println(this.name); //Kitty
        System.out.println(super.name); //Bello
    }

    public static void main(String[] args) {

        Cat cat1 = new Cat();
        Animal animal1 = cat1;

        System.out.println(cat1.name);
        System.out.println(animal1.name);
    }
}