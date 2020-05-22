public class Animal {
    private String name;
    public Animal(){
    }
    public void setName(String name) {
        this.name = name;
    }
}

public class Cat extends Animal {
    public Cat(String name) {
        super();
        setName(name);
    }
}