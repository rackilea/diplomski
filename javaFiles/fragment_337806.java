private static class ListItem {
    public ListItem(String text) {
        this.text = text;
    }

    private final String text;
    private final ObjectProperty<Color> color = new SimpleObjectProperty(Color.BLACK);
}