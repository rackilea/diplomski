public class CustomOptionModel implements OptionModel {
    private final String label;
    private final Object value;
    private final Map<String, String> attributes;

    public CustomOptionModel(final String label, 
                             final Object value, 
                             final String tooltip) {
        this.label = label;
        this.value = value;

        if (tooltip != null) {
            attributes = new HashMap<String, String>();
            attributes.put("title", tooltip);
        } else {
            attributes = null;
        }
    }

    public String getLabel() {
        return label;
    }

    public boolean isDisabled() {
        return false;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public Object getValue() {
        return value;
    }
}