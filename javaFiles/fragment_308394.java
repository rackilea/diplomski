public class ListObject {
    private String[] values;
    public ListObject(String... values) {
        this.values = values;
    }

    public int size() {
        return values == null ? 0 : values.length;
    }

    public String get(int index) {
        return values == null ? null : values[index];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        if (values != null) {
            for (String value : values) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(value);
            }
        }
        return sb.toString();
    }
}