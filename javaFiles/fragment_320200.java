Population<Dog> dogs = new Population<>();
dogs.add(new Dog());  // OK.

Population<Cat> cats = new Population<>();
cats.add(new Cat());  // OK.

dogs.add(new Cat());  // Compiler error.
cats.add(new Dog());  // Compiler error.