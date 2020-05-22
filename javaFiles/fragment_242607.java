HTMLEditorKit.ParserCallback callback = new HTMLEditorKit.ParserCallback() {
    private final Object[] attributesOfInterest = {
        HTML.Attribute.CLASS,
        HTML.Attribute.ID,
        "for",
        HTML.Attribute.NAME,
    };

    private void addAttributes(AttributeSet attr) {
        for (Object a : attributesOfInterest) {
            Object value = attr.getAttribute(a);
            if (value != null) {
                Collections.addAll(attributes,
                    value.toString().split("\\s+"));
            }
        }
    }

    @Override
    public void handleStartTag(HTML.Tag tag,
                               MutableAttributeSet attr,
                               int pos) {
        addAttributes(attr);
        super.handleStartTag(tag, attr, pos);
    }

    @Override
    public void handleSimpleTag(HTML.Tag tag,
                                MutableAttributeSet attr,
                                int pos) {
        addAttributes(attr);
        super.handleSimpleTag(tag, attr, pos);
    }
};

HTMLDocument doc = (HTMLDocument)
    new HTMLEditorKit().createDefaultDocument();
doc.getParser().parse(new StringReader(htmlContent), callback, true);