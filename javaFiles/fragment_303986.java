public void printCars(List<ViewCar> cars){
    cars.forEach(car -> {
        car.showMake();
        car.showModel();
    });
}