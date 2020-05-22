public class HelloWorld {

    /** Path to the resulting PDF file. */
    public static final String RESULT = "results/hello.pdf";
    public static final String FONT = "fonts/HelveticaRegular.ttf";

    /**
     * Creates a PDF file: hello.pdf
     * @param    args    no arguments needed
     */
    public static void main(String[] args)
            throws DocumentException, IOException {
        new HelloWorld().createPdf(RESULT);
    }

    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException
     * @throws    IOException
     */
    public void createPdf(String filename)
            throws DocumentException, IOException {
        Font font = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, true);

        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream(filename));

        document.open();

        document.add(new Paragraph("Hello World! Ты можешь использовать кирилицу.", font));

        document.close();
    }
}