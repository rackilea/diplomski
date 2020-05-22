// Returns true if the dog was fed
boolean feedDog(Dog dog) {
    if (!dog.isHungry()) {
        return false;
    }
    Food food;
    if (dog.isBadToday()) {
        food = getDefaultFood();
    } else {
        food = getTreat();
    }
    dog.feed(food);
    return true;
}