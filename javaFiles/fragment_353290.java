new XStream(new JsonHierarchicalStreamDriver() {
    @Override
    public HierarchicalStreamWriter createWriter(Writer writer) {
        return new HackJsonWriter(writer);
    }
});