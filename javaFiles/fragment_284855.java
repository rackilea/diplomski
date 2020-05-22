public class Animal {
    private String name;
    public Animal(String name){
        this.name = name;
    }
}

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}