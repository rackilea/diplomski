import java.util.*;

abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void accept(AnimalVisitor av);  // <-- Open up for visitors.

}