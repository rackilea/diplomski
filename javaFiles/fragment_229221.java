public class BarcodeMain {

    public static void main(String[] args) throws Exception {
        List<Barcode> barcodes = new ArrayList<>();
        barcodes.add(Barcode.newUPCA(8, 85909, 51226, 3));
        barcodes.add(Barcode.newQRCode("foobar"));

        for (Barcode barcode : barcodes) {
            switch (barcode.getType()) {
                case UPCA: {
                    BarcodeUPCA b = (BarcodeUPCA) barcode;
                    System.out.printf("UPC-A: %d, %d, %d, %d%n",
                            b.getNumberSystem(),
                            b.getManufacturer(),
                            b.getProduct(),
                            b.getCheck()
                    );
                    break;
                }
                case QRCode: {
                    BarcodeQRCode b = (BarcodeQRCode) barcode;
                    System.out.printf("QR code: %s%n", b.getProductCode());
                    break;
                }
                default:
                    System.err.println("unhandled type: " + barcode.getType());
            }
        }
}