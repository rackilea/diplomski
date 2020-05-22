PDDocument document = PDDocument.load(resource);
PDPage page = document.getDocumentCatalog().getPages().get(0);
PDPageContentStream cs = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.PREPEND, false, false);

Matrix matrix = Matrix.getRotateInstance(Math.toRadians(45), 0, 0);
PDRectangle cropBox = page.getCropBox();
float tx = (cropBox.getLowerLeftX() + cropBox.getUpperRightX()) / 2;
float ty = (cropBox.getLowerLeftY() + cropBox.getUpperRightY()) / 2;

Rectangle rectangle = cropBox.transform(matrix).getBounds();
float scale = Math.min(cropBox.getWidth() / (float)rectangle.getWidth(), cropBox.getHeight() / (float)rectangle.getHeight());

cs.transform(Matrix.getTranslateInstance(tx, ty));
cs.transform(matrix);
cs.transform(Matrix.getScaleInstance(scale, scale));
cs.transform(Matrix.getTranslateInstance(-tx, -ty));
cs.close();