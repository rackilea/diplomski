public String findFirstMotorName(Park park) {
        return Optional.ofNullable(park)
            .map(Park::getCars)
            .map(
                cars -> cars.stream().map(Car::getMotor).map(Motor::getName).findFirst().orElse(null)
            )
            .orElse("No Motors Found");
    }