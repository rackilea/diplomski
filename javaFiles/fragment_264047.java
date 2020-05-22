PDDocument document = PDDocument.load(resource);
PDPage page = document.getDocumentCatalog().getPages().get(0);
PDPageContentStream cs = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.PREPEND, false, false);
Matrix matrix = Matrix.getRotateInstance(Math.toRadians(45), 0, 0);
cs.transform(matrix);
cs.close();

PDRectangle cropBox = page.getCropBox();
float cx = (cropBox.getLowerLeftX() + cropBox.getUpperRightX()) / 2;
float cy = (cropBox.getLowerLeftY() + cropBox.getUpperRightY()) / 2;
Point2D.Float newC = matrix.transformPoint(cx, cy);
float tx = (float)newC.getX() - cx;
float ty = (float)newC.getY() - cy;
page.setCropBox(new PDRectangle(cropBox.getLowerLeftX() + tx, cropBox.getLowerLeftY() + ty, cropBox.getWidth(), cropBox.getHeight()));
PDRectangle mediaBox = page.getMediaBox();
page.setMediaBox(new PDRectangle(mediaBox.getLowerLeftX() + tx, mediaBox.getLowerLeftY() + ty, mediaBox.getWidth(), mediaBox.getHeight()));