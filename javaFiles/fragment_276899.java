@Test
public void flatMapCars() {
    Observable.from(getCars())
            .flatMap(this::saveCar)
            .subscribe();
}

private List<String> getCars() {
    return Arrays.asList("Aston martin", "Renault", "Seat");
}

private Observable<String> saveCar(String car) {
    return Observable.just(car);//You should save the car
}