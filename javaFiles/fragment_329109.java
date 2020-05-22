switch(trafficLight.state) {
    case GREEN:
    case YELLOW:
        // Now both GREEN and YELLOW will use this code
        car.drive();
        break;
    case RED:
        car.stop();
        break;
}