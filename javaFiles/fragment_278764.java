public class TrimmedLabel extends Label {
    private int size;

    public TrimmedLabel(String id, int size) {
        super(id);
        this.size = size;
    }

    public TrimmedLabel(String id, String label, int size) {
        super(id, label);
        this.size = size;
    }

    public TrimmedLabel(String id, IModel model, int size) {
        super(id, model);
        this.size = size;
    }

    @Override
    protected void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
        String value = getModelObjectAsString();
        if (value.length() > size) {
            value = value.substring(0, size);
        }
        replaceComponentTagBody(markupStream, openTag, value);
    }
}