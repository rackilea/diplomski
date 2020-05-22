class Dog extends Animal {

    public void treatWell(DogSpa spa) {
        spa.takeCareOf(this);      // pass this object to the spa
    }

    public void makeSound() {
        System.out.println("bark");
        super.makeSound();         // call makeSound in Animal scope
    }
}