PDDocument document = PDDocument.load(resource);
PDFTextStripper stripper = new PDFTextStripper() {
    @Override
    protected void processTextPosition(TextPosition textPosition) {
        try {
            writeString(String.format("%s%s", textPosition.getUnicode(), Arrays.toString(textPosition.getCharacterCodes())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
};

String text = stripper.getText(document);