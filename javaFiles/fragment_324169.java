Map<String, Set<String>> animals = new HashMap<>();

// To add a new category of animal
animals.put("Cat", new HashSet<>());
animals.put("Dog", new HashSet<>());

// To add a new animal to an existing category
animals.get("Cat").add("Puma");
animals.get("Cat").add("Tiger");
animals.get("Dog").add("Labrador");

// prints {Cat=[Tiger, Puma], Dog=[Labrador]}
System.out.println(animals);