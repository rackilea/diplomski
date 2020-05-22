class WoodenPlate extends Plate {
    private static int counter = 0;
    private int serialNumber;

    public WoodenPlate() {
        serialNumber = ++counter;
    }
}