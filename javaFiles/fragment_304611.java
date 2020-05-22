public int getNumCars() {
    int c = 0;
    for (int i = 0; i < this.cars.length; i++) {
        if (this.cars[i] != null) {
            c++;
        }
    }
    return c;
}