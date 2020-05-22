public enum DogName {
    buster, rover, fido
}

....
EnumMap<DogName,Dog> dogs = new EnumMap<DogName,Dog>();
for (DogName name : DogName.values()) {
    dogs.put(name, new Dog());
}