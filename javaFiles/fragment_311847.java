public class House {
    private Set<Dog> dogsInTheHouse = new HashSet<Dog>();

    public void addDog(Dog dog) {
        this.dogsInTheHouse.add(dog);
    }

    public void someOneIsAtTheDoor() {
        for (Dog dog : dogsInTheHouse) {
            dog.bark();
        }
    }
}