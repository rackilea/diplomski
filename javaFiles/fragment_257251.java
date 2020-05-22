private static final double PERIOD = 8; // loop every 8 calls to updateNumber
private static final double SCALE = 200; // go between 0 and this

private int _pos = 0;
private int Number1 = 0;

public void updateNumber() {
    _pos++;
    Number1 = (int)(Math.sin(_pos*2*Math.PI/PERIOD)*(SCALE/2) + (SCALE/2));
}