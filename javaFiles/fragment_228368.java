// Returns true if the dog was fed *a treat*
boolean feedDog(Dog dog) {
    if (!dog.isHungry()) {
        return false;
    }
    Food food;
    if (dog.isBadToday()) {
        food = getDefaultFood();
        return false; // Dog wasn't fed a treat
    } else {
        food = getTreat();
    }
    dog.feed(food);
    return true;
}