PDDocument document = PDDocument.load(resource);
PDPage page = document.getDocumentCatalog().getPages().get(0);
PDPageContentStream cs = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.PREPEND, false, false);
Matrix matrix = Matrix.getRotateInstance(Math.toRadians(45), 0, 0);
cs.transform(matrix);
cs.close();

PDRectangle cropBox = page.getCropBox();
Rectangle rectangle = cropBox.transform(matrix).getBounds();
PDRectangle newBox = new PDRectangle((float)rectangle.getX(), (float)rectangle.getY(), (float)rectangle.getWidth(), (float)rectangle.getHeight());
page.setCropBox(newBox);
page.setMediaBox(newBox);