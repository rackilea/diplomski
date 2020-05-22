public abstract class Parent {

    public abstract Set<? extends Offspring> getOffsprings();
}

public abstract class Offspring {

    public abstract Parent getParent();
}

public class Cat extends Parent {

    private Set<Kitten> offsprings;

    @Override
    public Set<Kitten> getOffsprings() {
        return offsprings;
    }
}

public class Kitten extends Offspring {

    private Cat parent;

    @Override
    public Cat getParent() {
        return parent;
    }
}

public class Dog extends Parent {

    private Set<Puppy> offsprings;

    @Override
    public Set<Puppy> getOffsprings() {
        return offsprings;
    }
}

public class Puppy extends Offspring {

    private Dog parent;

    @Override
    public Dog getParent() {
        return parent;
    }
}