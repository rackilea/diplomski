public final Collection<Apple> getApples() {
    if (apples == null) {
        // findApples would call the DB, or whatever it needs to do
        apples = findApples();
    return apples;
}

public void addApple(final Apple apple) {       
    //we are assured that getApples() won't return 
    //null since it's lazily instantiated in the getter
    getApples().add(apple);
}