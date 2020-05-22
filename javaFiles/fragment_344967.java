public static final Comparator<Dog> COMPARE_BY_AGE = new Comparator<Dog>() {
    @Override
    public int compare(Dog d, Dog d1) {
        return d.getDogAge() - d1.getDogAge();
    }
};

public static final Comparator<Dog> COMPARE_BY_HEIGHT = new Comparator<Dog>() {
    @Override
    public int compare(Dog d, Dog d1) {
        return d.getDogHeight() - d1.getDogHeight();
    }
};

public static final Comparator<Dog> COMPARE_BY_WEIGHT = new Comparator<Dog>() {
    @Override
    public int compare(Dog d, Dog d1) {
        return d.getDogWeight() - d1.getDogWeight();
    }
};