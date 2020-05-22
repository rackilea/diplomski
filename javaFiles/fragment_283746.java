Document document = new Document();
PdfWriter writer = PdfWriter.getInstance(document, ...);
document.open();
HeaderAddFooter headerAddFooter = new HeaderAddFooter("", "");
writer.setPageEvent(headerAddFooter);

for (int page = ...)
{
    String nameForPage = ...
    String idForPage = ...
    headerAddFooter.patientName = nameForPage;
    headerAddFooter.patientID = idForPage;

    ... add content for page ...
    document.newPage();
}

document.close();