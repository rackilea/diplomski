private Animal createAnimalFor(String className, String animalName) {
  switch (className) {
    case "Bird": return new Bird(animalName); 
    ...
    default: throw new IllegalArgumentException("Dont know how to create object for unknown class: " + className);
  }
}