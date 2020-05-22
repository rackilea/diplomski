public Class Car {
private int x;
private int y;
private Image image;

public Car(int x, int y) {
    this.x = x;
    this.y = y;
    image = new Image("location/car.png");
}

public int getX() {
    return x;
}

public void setX(int x) {
    this.x = x;
}

public int getY() {
    return y;
}

public void setY(int y) {
    this.y = y;
}