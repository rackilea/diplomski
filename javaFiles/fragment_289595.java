public class hippotest {
    public static void main(String[] args) {
        Hippo h = new Hippo("JP");
        System.out.println(h.getname());
    }
}

abstract class Animal {
    private String name;

    public Animal(String nameAnimal) { // new needs to be changed
        name = nameAnimal; //new is reserved keyword
    }

    public String getname() {
        return name;
    }
}

class Hippo extends Animal {
    public Hippo(String name) {
        super(name);
    }
}