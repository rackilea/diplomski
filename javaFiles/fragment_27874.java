import java.util.*;

interface Animal {
    public void talk ();
}

interface TreeClimbing {
    public void climbToATree ();
}

class Dog implements Animal {
    public void talk () { System.out.println("Woof!"); }
}

class Cat implements Animal, TreeClimbing {
    public void talk () { System.out.println("Meow!"); }    
    public void climbToATree () { System.out.println ("on top!"); }
}

public class TreeCriterion {

    public static void main(String[] args) {
        List <Animal> animals = new ArrayList <Animal> ();
        animals.add (new Cat ());
        animals.add (new Dog ());

        discuss (animals);
        upTheTree (animals);
    }

    public static void discuss (List <Animal> animals) {
        for (Animal a : animals)
            a.talk ();
    }

    public static void upTheTree (List <Animal> animals) {
        for (Animal a : animals) {
            if (a instanceof TreeClimbing)
                ((TreeClimbing) a).climbToATree ();
        }
    }
}