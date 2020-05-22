public class Zoo {
    private List<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void roar() {
        for(Animal a : animals) {
            a.makeNoise();
        }
    }
}