public enum Animal {
    CAT(0),
    COW(2),
    DOG(1),
    ELEPHANT(3);

    public static Comparator<Animal> getSizeComparator() {
        return Comparator.comparingInt(Animal::getSize);
    }

    private final int size;

    Animal(final int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}