public enum Status {
    A("A", 1),
    B("B", 1),
    C("C", 1),
    D("D", 2),
    E("E", 2);
    private String name;
    private int category;
    public String getName() { return name; }
    public int getCategory() { return category; }
    Status(String name, int category) {
        this.name = name;
        this.category = category;
    }
}