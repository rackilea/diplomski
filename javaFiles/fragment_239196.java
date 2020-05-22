public class Stationery extends PdfPageEventHelper
{
    [...]

    public void createPdf(String filename) throws Exception
    {
        // step 1
        Document document = new Document(PageSize.A4, 36, 36, 72, 36);
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        useStationary(writer);
        // step 3
        document.open();
        // step 4
        [... add content to PDF ...]
        // step 5
        document.close();
    }

    [...]

    public void useStationary(PdfWriter writer) throws IOException
    {
        writer.setPageEvent(this);
        PdfReader reader = new PdfReader(STATIONERY);
        page = writer.getImportedPage(reader, 1);
    }

    public void onEndPage(PdfWriter writer, Document document)
    {
        writer.getDirectContentUnder().addTemplate(page, 0, 0);
    }

    [...]
}