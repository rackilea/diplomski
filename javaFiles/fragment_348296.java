public class Animal {
    public void eat() { }

    public void walk() { }
}

public class Cat extends Animal {
    public void eat() {
        // eat like a cat
    }

    public void walk() {
        // walk like a cat (on four legs)
    }

public class Horse extends Animal {
    public void eat() {
        // eat like a horse
    }

    public void walk() {
        // walk like a horse
    }
}

Animal myAnimal;
switch(typeOfAnimal) {
    case 1: myAnimal = new Cat(); break;
    case 2: myAnimal = new Horse(); break;
}