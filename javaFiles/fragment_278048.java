Map<String, List<Dog>> dogses = new HashMap<String, List<Dog>>();
Map<String, List<? extends Animal>> animalses = dogses; // unsafe cast

List<Cat> cats = new ArrayList();
cats.put(new Cat());
animalses.put("cats", cats);

List<Dog> dogs = dogses.get("cats");
Dog dog = dogs.get(0); // uh-oh