PDDocument document = PDDocument.load(SOURCE);
for (PDPage page : document.getDocumentCatalog().getPages()) {
    PdfContentStreamEditor identity = new PdfContentStreamEditor(document, page) {
        @Override
        protected void write(ContentStreamWriter contentStreamWriter, Operator operator, List<COSBase> operands) throws IOException {
            String operatorString = operator.getName();

            if (TEXT_SHOWING_OPERATORS.contains(operatorString))
            {
                float fs = getGraphicsState().getTextState().getFontSize();
                Matrix matrix = getTextMatrix().multiply(getGraphicsState().getCurrentTransformationMatrix());
                Point2D.Float transformedFsVector = matrix.transformPoint(0, fs);
                Point2D.Float transformedOrigin = matrix.transformPoint(0, 0);
                double transformedFs = transformedFsVector.distance(transformedOrigin);
                if (transformedFs > 100)
                    return;
            }

            super.write(contentStreamWriter, operator, operands);
        }

        final List<String> TEXT_SHOWING_OPERATORS = Arrays.asList("Tj", "'", "\"", "TJ");
    };
    identity.processPage(page);
}
document.save(RESULT);