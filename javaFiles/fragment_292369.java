void swapEngine(Car a, Car b) {
    Comparator<Car> byId = Comparator.comparing(Car::id);
    Car[] cars = new Car[] {a, b};
    Arrays.sort(cars, byId);
    doSwap(cars[0]), cars[1];
}

private void doSwap(Car a, Car b) { 
    synchronized(a) {
        synchronized(b) {
            Engine temp = a.engine;
            a.engine = b.engine;
            b.engine = temp;
        }
    }
}