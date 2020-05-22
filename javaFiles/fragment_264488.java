item.setStartElementListener(new StartElementListener() {
    @Override
    public void start(Attributes attributes) {
        position = attributes.getValue("pos");
    }
});