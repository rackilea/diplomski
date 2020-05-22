switch(trafficLight.state) {
    case GREEN:
        car.drive();
        break;
    case YELLOW:
        car.drive();
        break;
    case RED:
        car.stop();
        break;
}