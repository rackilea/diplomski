class BarcodeQRCode extends Barcode {

    private final String productCode;

    public BarcodeQRCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }

    @Override
    public BarcodeType getType() {
        return BarcodeType.QRCode;
    }
}