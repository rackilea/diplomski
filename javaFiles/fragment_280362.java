interface Vehicle<U extends Vehicle<U, T>, T extends SteeringDevice<T, U>> {
    default void steer(T steeringDevice) {}
}

interface SteeringDevice<T extends SteeringDevice<T, U>, U extends Vehicle<U, T>> {
    // ...
}

class Car implements Vehicle<Car, SteeringWheel> {
    // ...
}

class SteeringWheel implements SteeringDevice<SteeringWheel, Car> {
    // ...
}