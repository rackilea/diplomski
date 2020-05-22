private void goodChangeDog(Dog dog) {
    dog.setColor(Color.BLACK); // works as expected!
}
private void badChangeDog(Dog dog) {
    dog = new StBernard(); // compiles, but has no effect outside the method
}