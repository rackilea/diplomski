Map<String,Dog> map = new HashMap<>();
array.stream().forEach(dog -> map.merge(dog.name, dog, (d1, d2) -> {
    return new Dog(d1.name, d1.count + d2.count);
}));

ArrayList<Dog> mergedDogs = new ArrayList<>(map.values());