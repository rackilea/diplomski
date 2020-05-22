public List<? extends Animal> getAllPets(...) {
    List<Dog> allDogs = findDogs();
    List<Cat> allCats = findCats();
    List<Animal> retObjs = new ArrayList<>(allDogs.size() + allCats.size());
    retObjs.addAll(allDogs);
    retObjs.addAll(allCats);
    return retObjs;
}