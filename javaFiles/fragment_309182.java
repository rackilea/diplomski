PdfDocument pdfDocument = new PdfDocument(new PdfWriter("..."));
pdfDocument.addNewPage();
int pageNumber = 1;
PdfPage page = pdfDocument.getPage(pageNumber);

String text = "Hello World! This is an answer to a SO question";
Paragraph paragraph = new Paragraph(text).
      setMargin(0).
      setMultipliedLeading(1).
      setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));

float fontSize = 50;
paragraph.setFontSize(fontSize);
paragraph.setBackgroundColor(Color.RED); // Just to see that text is aligned correctly
float allowedWidth = 185;

Canvas canvas = new Canvas(new PdfCanvas(page), pdfDocument, page.getMediaBox());
RootRenderer canvasRenderer = canvas.getRenderer();
while (paragraph.createRendererSubTree().setParent(canvasRenderer).layout(new LayoutContext(new LayoutArea(pageNumber, new Rectangle(allowedWidth, fontSize * 2)))).getStatus() != LayoutResult.FULL) {
    paragraph.setFontSize(--fontSize);
}
float xCoord = 151;
float yCoord = 73;

paragraph.setWidth(allowedWidth);
canvas.showTextAligned(paragraph, xCoord, yCoord, TextAlignment.CENTER);
canvas.close();
pdfDocument.close();