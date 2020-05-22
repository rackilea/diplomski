class TextWithFont {
    final String text;
    final PDFont font;

    TextWithFont(String text, PDFont font) {
        this.text = text;
        this.font = font;
    }

    public void show(PDPageContentStream canvas, float fontSize) throws IOException {
        canvas.setFont(font, fontSize);
        canvas.showText(text);
    }
}