public class Item {
    private String displayText;
    private String meta;

    public Item(String displayText, String meta) {
        this.displayText = displayText;
        this.meta = meta;
    }

    public Item() {
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (displayText != null ? !displayText.equals(item.displayText) : item.displayText != null) return false;
        return !(meta != null ? !meta.equals(item.meta) : item.meta != null);
    }

    @Override
    public int hashCode() {
        int result = displayText != null ? displayText.hashCode() : 0;
        result = 31 * result + (meta != null ? meta.hashCode() : 0);
        return result;
    }
}