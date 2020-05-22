class BarcodeUPCA extends Barcode {
    private final int numberSystem;
    private final int manufacturer;
    private final int product;
    private final int check;

    public BarcodeUPCA(int numberSystem, int manufacturer, int product, int check) {
        this.numberSystem = numberSystem;
        this.manufacturer = manufacturer;
        this.product = product;
        this.check = check;
    }

    public int getNumberSystem() {
        return numberSystem;
    }

    public int getManufacturer() {
        return manufacturer;
    }

    public int getProduct() {
        return product;
    }

    public int getCheck() {
        return check;
    }

    @Override
    public BarcodeType getType() {
        return BarcodeType.UPCA;
    }
}