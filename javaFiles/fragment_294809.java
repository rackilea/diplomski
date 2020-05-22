public Cars(Cars other) {
    this.type = other.type;
    this.number = other.number;
    this.cars = Arrays.stream(other.cars)
        .map(Models::new)
        .toArray(Models[]::new);
}