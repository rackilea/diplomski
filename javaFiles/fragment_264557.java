for(dogs : hashMap.values()) {
    for(dog : dogs) {
        dogService.delete(dog);
        dogService.save(dog);
    }
    dogs.clear();
}