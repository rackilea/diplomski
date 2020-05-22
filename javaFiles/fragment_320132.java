public void parkCar(Car car) {
    for (int i = 0; i < cars.length; i++) {
        if (cars[i] == null) {
            cars[i] = car;
            break; // do not allocate other null spaces with same car, leave space for the next cars
        }
    }
}