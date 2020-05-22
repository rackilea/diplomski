Document document = new Document();
PdfWriter writer = PdfWriter.getInstance(document, ...);
document.open();

for (int page = ...)
{
    String nameForPage = ...
    String idForPage = ...
    writer.setPageEvent(new HeaderAddFooter(nameForPage, idForPage));

    ... add content for page ...
    document.newPage();
}

document.close();