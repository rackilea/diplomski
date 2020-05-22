public interface Animal {
    void setName(String name);
    String getName();
    void printInfo();
}

public abstract class AbstractAnimal implements Animal {
    private String name;
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    abstract void printInfo();
}

public class Cat extends AbstractAnimal {
    @Override
    public void printInfo(){
        System.out.println("I'm a cat");
    }
}

public class Dog extends AbstractAnimal {
    @Override
    public void printInfo(){
        System.out.println("I'm a dog");
    }
}