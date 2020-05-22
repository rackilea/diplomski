PDDocument document = new PDDocument();

PDImageXObject ximage = JPEGFactory.createFromStream(document,imageResource);

PDPage page = new PDPage(new PDRectangle(ximage.getWidth(), ximage.getHeight()));
document.addPage(page);

PDPageContentStream contentStream = new PDPageContentStream(document, page);
contentStream.drawImage(ximage, 0, 0);
contentStream.close();