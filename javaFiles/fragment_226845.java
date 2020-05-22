public static void reorder(Animal[] animals) {
    if (animals == null) {
        return;
    }
    int goats = countGoats(animals);
    for (int i = 0; i < animals.length; i++) {
        // if (i < goats) - it's a goat, otherwise it's a sheep.
        animals[i] = (i < goats) ? Animal.goat : Animal.sheep;
    }
}