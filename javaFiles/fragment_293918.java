abstract class Animal {

    void makeNoise() { System.out.println(noise()); }
    abstract String noise();
}

class Dog extends Animal {

    @Override
    String noise() { return "Woof!"; }

}

class Cat extends Animal {

    @Override
    String noise() { return "Meow!"; }

}