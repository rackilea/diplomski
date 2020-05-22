public interface Animal {
    String getName();
    String makeNoise();
    void accept(AnimalVisitor v);
}

public interface AnimalVisitor() {
    void visit(Cat a);
    void visit(BaldEagle a);
}

public interface CanFly {
    float getMaxInAirDistanceKm();
}

public class Cat implements Animal {
    void accept(Visitor v) {
        v.visit(this);
    }
}

public class BaldEagle implements Animal, CanFly {
    void accept(Visitor v) {
        v.visit(this);
    }
}

public class DisplayVisitor implements AnimalVisitor  {
    void visit(Cat a) {
       //build & display your string
    }

    void visit(BaldEagle a) {
       //build & display your string
    }
}

public class Catalog {
    private List<Animal> animals = new ArrayList<>();

    public void putAnimal(Animal animal) {
        animals.add(animal);
    }

    public void showList() {
        DisplayVisitor display = new DisplayVisitor();
        animals.forEach(a->a.accept(display));
    }
}