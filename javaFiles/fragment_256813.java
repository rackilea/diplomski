public class Contains {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contains")
    @Expose
    private List<Contains> contains;

    public Contains(String name) {
        this.name = name;
        contains = new ArrayList<Contains>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Contains c) {
        this.contains.add(c);
    }

    public void setContainerList(List<Contains> contains) {
        this.contains = contains;
    }

    public String getName() {
        return name;
    }

    public List<Contains> getContainerList() {
        return this.contains;
    }
}