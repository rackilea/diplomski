// Returns true if the dog was fed *a treat*
boolean feedDog(Dog dog) {
    if (!dog.isHungry()) {
        return false;
    }
    Food food;
    boolean fedTreat = false;
    if (dog.isBadToday()) {
        food = getDefaultFood();
    } else {
        food = getTreat();
        fedTreat = true;
    }
    dog.feed(food);
    return fedTreat;
}