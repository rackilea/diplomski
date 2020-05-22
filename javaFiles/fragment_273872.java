public class MyPDFGeneratorService {

    public byte[] generatePdf(final XhtmlPDFGenerationRequest request) {
        try {

            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(this.getDocument(request.getContent()), null);
            renderer.layout();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            renderer.createPDF(baos);
            return this.toByteArray(baos);

        }
        catch (Exception e) {
            throw new PDFGenerationException(
                    "Unable to generate  PDF.", e);
        }
    }

    private Document getDocument(final String content) {
        InputSource is = new InputSource(new BufferedReader(new StringReader(
                content)));
        return XMLResource.load(is).getDocument();
    }


    private byte[] toByteArray(final ByteArrayOutputStream baos)
        throws IOException {
    byte[] bytes = baos.toByteArray();
    baos.close();
    return bytes;

 }

}