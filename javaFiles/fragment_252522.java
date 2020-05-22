interface Positioned {
    int getX();
    int getY();
 }

class Water implements Positioned {
    int getX() { return xLoc; }
    ...
}