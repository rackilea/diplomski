public class Change {
    private String format;
    private String description;

    public Change(String format, String description) {
        this.format = format;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public static void main(String[] args) {
        List<Change> list = new ArrayList<>();
        list.add(new Change("format1", "descr1"));
        list.add(new Change("formatelse", "descrelse"));

        Set<String> formats = list.stream().map(Change::getFormat).collect(Collectors.toSet());
    }
}