class GenericTags extends PdfPageEventHelper {

    public void onGenericTag(PdfWriter writer, Document pdfDocument,
            Rectangle rect, String text) {
        if ("strip".equals(text))
            strip(writer.getDirectContent(), rect);
        else if ("ellipse".equals(text))
            ellipse(writer.getDirectContentUnder(), rect);
        else
            countYear(text);
    }

    public void strip(PdfContentByte content, Rectangle rect) {
        content.rectangle(rect.getLeft() - 1, rect.getBottom() - 5f,
                rect.getWidth(), rect.getHeight() + 8);
        content.rectangle(rect.getLeft(), rect.getBottom() - 2,
                rect.getWidth() - 2, rect.getHeight() + 2);
        float y1 = rect.getTop() + 0.5f;
        float y2 = rect.getBottom() - 4;
        for (float f = rect.getLeft(); f < rect.getRight() - 4; f += 5) {
            content.rectangle(f, y1, 4f, 1.5f);
            content.rectangle(f, y2, 4f, 1.5f);
        }
        content.eoFill();
    }

    public void ellipse(PdfContentByte content, Rectangle rect) {
        content.saveState();
        content.setRGBColorFill(0x00, 0x00, 0xFF);
        content.ellipse(rect.getLeft() - 3f, rect.getBottom() - 5f,
                rect.getRight() + 3f, rect.getTop() + 3f);
        content.fill();
        content.restoreState();
    }

    TreeMap<String, Integer> years = new TreeMap<String, Integer>();

    public void countYear(String text) {
        Integer count = years.get(text);
        if (count == null) {
            years.put(text, 1);
        }
        else {
            years.put(text, count + 1);
        }
    }
}