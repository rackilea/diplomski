public class BarCodeTest {

    public static void main(String[] a) throws FileNotFoundException, DocumentException {
        Barcode128 code128 = new Barcode128();
        code128.setCode("P662130002");
        code128.setBarHeight(80f); // great! but what about width???
        code128.setX(1f);
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("hello.pdf"));
        document.open();

        PdfContentByte cb = writer.getDirectContent();

        Image barcodeimage = code128.createImageWithBarcode(cb, Color.BLACK, Color.WHITE);
        document.add(barcodeimage);

        document.close();

    }

}