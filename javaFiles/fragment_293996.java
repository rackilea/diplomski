public void whatDoesItEat(IAnimal animal) {
    animal.eat();
}

Tiger tiger = new Tiger();
HouseCat houseCat = new HouseCat();

whatDoesItEat(tiger);
whatDoesItEat(houseCat);