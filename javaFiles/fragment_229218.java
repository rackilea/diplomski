abstract class Barcode {

    abstract public BarcodeType getType();

    public static final Barcode newUPCA(int numberSystem, int manufacturer, int product, int check) {
        return new BarcodeUPCA(numberSystem, manufacturer, product, check);
    }

    public static final Barcode newQRCode(String productCode) {
        return new BarcodeQRCode(productCode);
    }
}