List<Dog> dogs = ...
Map<String, Integer> dogNames = new HashMap<>();
dogs.forEach(dog -> dogNames.put(dog.getName(), dogNames.getOrDefault(dog.getName(), 0) + 1));

Comparator<Dog> comp = Comparator.comparing(d -> dogNames.get(d.getName()));
System.out.println("least " + Collections.min(dogs, comp));
System.out.println("most  " + Collections.max(dogs, comp));