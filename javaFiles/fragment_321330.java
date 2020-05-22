public <E extends Animal> void addAllAnimals(List<E> animalLikeList, E animal) {
    animalLikeList.add(animal);
}

List<Dog> dogs = new ArrayList<Dog>();
List<Cat> cats = new ArrayList<Cat>();

addAllAnimals(dogs, new Dog());
addAllAnimals(cats, new Cat());