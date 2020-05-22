List<Dog> dogs = new ArrayList<Dog>();
List<Animal> animals = dogs; // unsafe cast

// this operation violates type safety
animals.add(new Cat());

// would assign a Cat to a variable of type Dog without a compile error!
Dog dog = animals.get(0);