HashMap<String, Animal> animals = new HashMap<String, Animal>();
// ...
Animal animal = new Animal();
animal.setName("Lion");
animal.setId(1);
animals.put(animal.getName(), animal);

// to modify...

Animal lion = animals.remove("Lion"); // no looping, it finds it in constant time
lion.setName("Brown Lion");
animals.put(animal.getName(), animal);