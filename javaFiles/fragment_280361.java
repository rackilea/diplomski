interface Vehicle<T extends SteeringDevice<? extends Vehicle<T>>> {
    default void steer(T steeringDevice) {}
}

interface SteeringDevice<U extends Vehicle<? extends SteeringDevice<U>>> {
    // ...
}