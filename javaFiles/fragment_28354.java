float fontSize = 12;
String text = "a";

PDRectangle pageSize = PDRectangle.A4;
PDFont font = PDType1Font.HELVETICA_BOLD;


PDDocument doc = new PDDocument();
PDPage page = new PDPage(pageSize);
doc.addPage(page);

PDPageContentStream stream = new PDPageContentStream(doc,page);
stream.setFont( font, fontSize );

// charWidth is in points multiplied by 1000.
double charWidth = font.getStringWidth(text);
charWidth *= fontSize; // adjust for font-size.

stream.beginText();
stream.moveTextPositionByAmount(0,10);

float widthLeft = pageSize.getWidth();
widthLeft *= 1000.0; //due to charWidth being x1000.

while(widthLeft > charWidth){
    stream.showText(text);
    widthLeft -= charWidth;
}

stream.close();
// Save the results and ensure that the document is properly closed:
doc.save( "example.pdf");
doc.close();