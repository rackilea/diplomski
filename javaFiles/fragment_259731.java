// Movement
public void move(int speed) {
    x += speed * Math.cos(direction * Math.PI / 180);
    y += speed * Math.sin(direction * Math.PI / 180);
}
// Pointing toward an object
public void pointToward(SObject target) {
    direction = Math.atan2(target.y - y, target.x - x) * (180 / Math.PI);
}
// Pointing toward the mouse
public void pointTowardMouse() {
    direction = Math.atan2(Main.mouse.getY() - y, Main.mouse.getX() - x) * (180 / Math.PI);
}
// Ensure that the degrees of rotation stay between 0 and 359
public void turn(int degrees) {
    double newDir = direction;
    newDir += degrees;
    if (degrees > 0) {
        if (newDir > 359) {
            newDir -= 360;
        }
    } else if (degrees < 0) {
        if (newDir < 0) {
            newDir += 360;
        }
    }
    direction = newDir;
}