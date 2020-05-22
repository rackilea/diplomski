public enum Priority {
    URGENT ("Urgent", 10),
    HIGH   ("High",    5),
    MEDIUM ("Medium",  2),
    LOW    ("Low",     0),
    DEFAULT("Default",-1);

    @Getter
    private final String name;

    private final int value;

    Priority(String name, int value) {
        this.name  = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return getName();
    }

    public int compare(Priority that) {
        return Integer.compare(this.value, that.value);
    }
}