// Check if outside left border
if(car.getX() < 0) {
    car.setX(0);
}
// Check if outside top border
if(car.getY() < 0) {
    car.setY(0);
}
// Check if outside right border
if(car.getX() >= SCREEN_WIDTH - car.getWidth()) {
    car.setX(SCREEN_WIDTH - car.getWidth());
}
// Check if outside bottom border
if(car.getY() >= SCREEN_HEIGHT - car.getHeight()) {
    car.setY(SCREEN_HEIGHT - car.getHeight());
}