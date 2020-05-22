class Animal {
    int health = 100;
    void eat(Food f) {
        health += f.value;
    }
}

class Dog extends Animal { // States that "All Dogs are Animals"
    // The word "extends" allows you to write Animal a = new Dog();
    // "extends" also lets you do "Dog a = new Dog(); a.eat()"
    int health = 150; // Dogs are strong
    void bark() {
        scareNearbyAnimals();
    }
}

class Poodle extends Dog {
    // Both of these will work:
    // Dog mydog = new Poodle();
    // Animal mypet = new Poodle();
    int glamor = 50; // glamorous
}