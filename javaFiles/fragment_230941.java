List<Dog> getCityDogs() {
    List<Dog> dogs = new ArrayList<>();
    HugeKennel k1 = ...
    dogs.addAll(k1.getDogs());
    HugeKennel k2 = ...
    dogs.addAll(k2.getDogs());
    return dogs;
}

....

List<Dog> cityDogs = getCityDogs();
for (Dog dog: dogs) {
    walkTheDog(dog);
}
// even though the Kenels were local variables in of getCityDogs(), they cannot be removed from the memory, as the SneakyDogs in the list are still referencing their parent kennels.
//from now on, until all the dogs are not disposed off, the kennels also have to stay in the memory.