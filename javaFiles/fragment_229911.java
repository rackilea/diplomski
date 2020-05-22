class LoopClass(){
    ...
    Car car = new Car();
    Bicycle bicycle = new Bicycle();

    LoopClass(){
        ArrayList<TickInterface> rides = new ArrayList<TickInterface>();
        rides.add(car);
        rides.add(bicycle);
    }

    void thisLoopsEveryFrame(){
        for(TickInterface ride : rides){
            ride.tick();
        }
    }

    void refuelCar(){
        car.refuel(); // possible now car has compile-time type of Car
    }
}