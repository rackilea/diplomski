class Animals{
    int size;
    String name;
    abstract void makeSound();
}
class Dogs extends Animals{
    void makeSound(){
        System.out.println("Woff");
    }
}

class Cats extends Animals{
    void makeSound(){
        System.out.println("Meow");
    }
}