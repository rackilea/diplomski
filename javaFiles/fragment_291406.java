public abstract class Animal {

    /** Common name property for all animals */
    private String name;

    /** Common age property for all animals */
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
         return name;
    }

    public void setAge(int age) {
        this.age= age;
    }

    public int getAge() {
         return age;
    }

    /** 
    * Abstract method that will need to be implemented 
    * by a concrete class that inherits from this abstract class
    */
    public abstract String getInfo();

    public abstract String speak();

    public abstract String getType();
}

public class Dog extends Animal {

     /*
     Any Dog specific properties would also go in here
     */       

    private boolean isPedigree = false;

    /** Class Constructor */
    public Dog(String name, int age, boolean isPedigree) {
        super(name, age);
        this.isPedigree = isPedigree;
    }

    public boolean isPedigree() {
        return isPedigree;
    }

    @Override
    public String getInfo() {
        return "I am a Dog named " + name + " and I am " + age + " years old.";
    }

    @Override
    public String speak() {
        return "WOOF";
    }

    @Override
    public String getType() {
        return Dog.class.getSimpleName();
    }
}

public class Cat extends Animal() {

     /*
     Any Cat specific properties would also go in here
     */

     /** Class Constructor */
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String getInfo() {
        return "I am a " + getType() + named " + name + " and I am " + age + " years old.";
    }

    @Override
    public String speak() {
        return "meow";
    }

    @Override
    public String getType() {
        return Cat.class.getSimpleName();
    }
}

public class MyMainClass {
    public static void main(String[] args) {
        /*
         Just creating a random array to show that
         any animal whether Dog or Cat can be placed into
         this array as they inherit from Animal
        */
        List<Animal> animals = new ArrayList<>();

        animals.add(new Dog("James", 5, true));
        animals.add(new Cat("Treacle", 2));

        for (Animal animal : animals) {
            display(animal);
            if (animal instanceof Dog) {
                boolean isPedigree = ((Dog) animal).isPedigree();
                System.out.println("Q: Am I a Pedigree? A: " + String.valueOf(isPedigree));
            }
        }
    }

    private void display(Animal animal) {
        System.out.println("I'm an animal of type " + animal.getType() + " and I can say " + animal.speak());
        System.out.println(animal.getInfo());
    }
}