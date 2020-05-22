// create empty list
List<Animal> animals = new ArrayList<>();

// add any kind of animal
animals.add(new Kangaroo());
animals.add(new Butterfly());

// use that list later
int numberOfAnimals = animals.size();
for (Animal animal : animals) {
    // do something
}