private static int countGoats(Animal[] animals) {
    int count = 0;
    for (Animal a : animals) {
        if (Animal.goat == a) {
            count++;
        }
    }
    return count;
}