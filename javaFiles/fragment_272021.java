Optional<Animal> catToAnimal(Cat cat) {
    return Optional.empty();
}

Function<Cat, Optional<Animal>> function2b = this::catToAnimal;
List<Animal> animalList2b = transform(catList, function2b);