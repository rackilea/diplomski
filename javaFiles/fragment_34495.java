PDDocument document = PDDocument.load(...);
List<PDAnnotation> annotations = document.getPage(0).getAnnotations();
PDAnnotationTextMarkup highlight = new PDAnnotationTextMarkup(PDAnnotationTextMarkup.SUB_TYPE_SQUIGGLY);
highlight.setRectangle(new PDRectangle(72, 500, 72, 18));
highlight.setQuadPoints(new float[]{72.0f,518.0f,142.002f,518.0f,72.0f,500.0f,142.002f,500.0f});
PDColor yellow = new PDColor(new float[] { 1, 1, 100 / 255F }, PDDeviceRGB.INSTANCE);
highlight.setColor(yellow);
annotations.add(highlight);
document.save(...);