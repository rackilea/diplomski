PDFont font = PDType1Font.HELVETICA;
float fontSize = 14;
float fontHeight = fontSize;
float leading = 20;
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
Date date = new Date();

PDDocument doc = new PDDocument();
PDPage page = new PDPage();
doc.addPage(page);

PDPageContentStream contentStream = new PDPageContentStream(doc, page);
contentStream.setFont(font, fontSize);

float yCordinate = page.getCropBox().getUpperRightY() - 30;
float startX = page.getCropBox().getLowerLeftX() + 30;
float endX = page.getCropBox().getUpperRightX() - 30;

contentStream.beginText();
contentStream.newLineAtOffset(startX, yCordinate);
contentStream.showText("Entry Form – Header");
yCordinate -= fontHeight;  //This line is to track the yCordinate
contentStream.newLineAtOffset(0, -leading);
yCordinate -= leading;
contentStream.showText("Date Generated: " + dateFormat.format(date));
yCordinate -= fontHeight;
contentStream.endText(); // End of text mode

contentStream.moveTo(startX, yCordinate);
contentStream.lineTo(endX, yCordinate);
contentStream.stroke();
yCordinate -= leading;

contentStream.beginText();
contentStream.newLineAtOffset(startX, yCordinate);
contentStream.showText("Name: XXXXX");
contentStream.endText();

contentStream.close();
doc.save("textLineText.pdf");