static enum ByName implements Comparator<Car> {
    INSTANCE;

    @Override
    public int compare(Car c1, Car c2) {
        return c1.name().compareTo(c2.name());
    }
}