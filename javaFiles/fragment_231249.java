public class LambdaCharacter {
    public static final String DEST = "results/fonts/lambda_character.pdf";
    public static final String FONT = "c:/windows/fonts/arial.ttf";
    public static final String TEXT = "Always use the Unicode notation for special characters: \u03bb";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new LambdaCharacter().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font f = new Font(bf, 12);
        Paragraph p = new Paragraph(TEXT, f);
        document.add(p);
        document.close();
    }
}