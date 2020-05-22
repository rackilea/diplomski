public static class Footer extends PdfPageEventHelper {
    private final Rectangle boundingBox;
    private final List<Element> elements;
    private PdfTemplate template = null;
    private float blankAfter = 0;

    public Footer(String html, float width) throws DocumentException, IOException {
        this(XMLWorkerHelper.parseToElementList(html, null), width);
    }

    public Footer(List<Element> elements, float width) throws DocumentException, IOException {
        this.elements = elements;
        try (   OutputStream os = new NullOutputStream()    ) {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, os);
            document.open();

            Rectangle bbox = new Rectangle(0, 0, width, 1000);
            float bottomLine = createTemplate(writer, bbox);
            boundingBox = new Rectangle(width, bbox.getTop() - bottomLine);
            template = null;

            writer.setPageEmpty(false);
            document.close();
        }
    }

    float createTemplate(PdfWriter writer, Rectangle boundingBox) throws DocumentException {
        template = writer.getDirectContent().createTemplate(10000, 10000);
        template.setBoundingBox(boundingBox);
        ColumnText columnText = new ColumnText(template);
        Rectangle bbox = template.getBoundingBox();
        columnText.setSimpleColumn(bbox.getLeft(), bbox.getBottom(), bbox.getRight(), bbox.getTop());
        for (Element element : elements) {
            columnText.addElement(element);
        }
        columnText.go();
        return columnText.getYLine() + columnText.getDescender();
    }

    void ensureTemplate(PdfWriter writer) throws DocumentException {
        if (template == null) {
            createTemplate(writer, boundingBox);
        }
    }

    public void setBottomMargin(Document document, float blankBefore, float blankAfter) {
        float marginBottom = boundingBox.getHeight() + blankBefore + blankAfter;
        document.setMargins(document.leftMargin(), document.rightMargin(), document.topMargin(), marginBottom);
        this.blankAfter = blankAfter;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        try {
            ensureTemplate(writer);

            Rectangle bbox = template.getBoundingBox();
            Rectangle pageSize = document.getPageSize();

            float x = pageSize.getLeft((pageSize.getWidth() - bbox.getWidth()) / 2f - bbox.getLeft());
            float y = pageSize.getBottom(blankAfter - bbox.getBottom());
            writer.getDirectContentUnder().addTemplate(template, x, y);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        super.onEndPage(writer, document);
    }
}