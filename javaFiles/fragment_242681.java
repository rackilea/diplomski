public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Duck duck = new Duck();
        Cat cat = new Cat();

        Collection<Animal> hungryAnimals = new ArrayList<Animal>();
        hungryAnimals.add(dog);
        hungryAnimals.add(duck);
        hungryAnimals.add(cat);

        for (Animal a: hungryAnimals){
            if (ValidAnimals.isValid(a)){
                a.feedAnimal();
            }
        }
    }

}