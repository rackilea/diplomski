public void run() {
    Zoo zoo = new Zoo();
    zoo.addAnimal(new Cat("Bob"));
    zoo.addAnimal(new Dog());
    zoo.addAnimal(new Cat("William"));
    zoo.roar();
}