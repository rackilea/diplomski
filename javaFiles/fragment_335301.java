import java.util.ArrayList;
import java.util.List;

public class Main {

    //i assume that this initialization of DatabaseOfAnimals is 
    //done in the GUI class constructor. (remove static modifier) 
    static DatabaseOfAnimals db = new DatabaseOfAnimals();

    public static void main(String[] args) {

        addAnimal("Sancho", 8);//this should be executed by Add button
    }

    //remove static modifier 
    static void addAnimal(String name, float mass) {

        db.addAnimal(new Animal(name, mass));
    }
}

class Animal{
    Animal(String name, float mass){/*do something*/}
}

class DatabaseOfAnimals{

    List<Animal> list;

    public DatabaseOfAnimals() {
        list = new ArrayList<>();
    }

    void addAnimal(Animal animal) {
        list.add(animal);
    }
}