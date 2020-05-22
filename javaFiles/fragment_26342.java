public class Animals {
private Animals() {
}

interface Animal {
    void accept(final AnimalProcessor visitor);
}

interface AnimalProcessor {
    void visitTailed(final TailedAnimal tailedAnimal);

    void visitHorned(final HornedAnimal hornedAnimal);
}

interface TailedAnimal extends Animal {
    void moveTail();
}

interface HornedAnimal extends Animal {
    void hitWithHorns();
}

static class Dog implements TailedAnimal {
    public void moveTail() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void accept(final AnimalProcessor visitor) {
        visitor.visitTailed(this);
    }
}

static class Cat implements TailedAnimal {
    public void moveTail() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void accept(final AnimalProcessor visitor) {
        visitor.visitTailed(this);
    }
}

static class Ram implements HornedAnimal {
    public void hitWithHorns() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void accept(final AnimalProcessor visitor) {
        visitor.visitHorned(this);
    }
}

static class Rhinoceros implements HornedAnimal, TailedAnimal {
    public void hitWithHorns() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void moveTail() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void accept(final AnimalProcessor visitor) {
        visitor.visitTailed(this);
        visitor.visitHorned(this);
    }
}

public static void main(String[] args) {
    Collection<Animal> animals = new ArrayList<Animal>(Arrays.asList(new Dog(), new Cat(), new Rhinoceros()));
    for (final Animal animal : animals) {
        animal.accept(new AnimalProcessor() {
            public void visitTailed(final TailedAnimal tailedAnimal) {
                // you do what you want when it's a tailed animal
            }

            public void visitHorned(final HornedAnimal hornedAnimal) {
                // you do what you want when it's a horned animal
            }
        });
    }
}
}