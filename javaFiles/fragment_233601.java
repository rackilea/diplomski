public static class Model {
    private ArrayList<Entry> entry;

    public Model(List<Entry> entries) {
        entry = entries; // or make a copy 
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Entry> getEntry() {
        return entry
    }

}