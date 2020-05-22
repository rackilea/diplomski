public class Ship {

private String shipName;
private String shipSize;

public Ship(String shipName, String shipSize) {
    this.shipName = shipName;
    this.shipSize = shipSize;
}

public String getShipName() {
    return shipName;
}

public String getShipSize() {
    return shipSize;
}

public void setShipName(String shipName) {
    this.shipName = shipName;
}

public void setShipSize(String shipSize) {
    this.shipSize = shipSize;
}