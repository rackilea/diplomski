PdfReader readerText = new PdfReader(docText);
cropPdf(readerText);
PdfReader readerGraphics = new PdfReader(docGraphics);
cropPdf(readerGraphics);
try (   FileOutputStream fos = new FileOutputStream(new File(RESULT_FOLDER, "importPages.pdf")))
{
    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, fos);
    document.open();
    document.add(new Paragraph("Let's import 'textOnly.pdf'", new Font(FontFamily.HELVETICA, 12, Font.BOLD)));
    document.add(Image.getInstance(writer.getImportedPage(readerText, 1)));
    document.add(new Paragraph("and now 'graphicsOnly.pdf'", new Font(FontFamily.HELVETICA, 12, Font.BOLD)));
    document.add(Image.getInstance(writer.getImportedPage(readerGraphics, 1)));
    document.add(new Paragraph("That's all, folks!", new Font(FontFamily.HELVETICA, 12, Font.BOLD)));

    document.close();
}
finally
{
    readerText.close();
    readerGraphics.close();
}