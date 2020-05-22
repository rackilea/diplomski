class WidgetHolder {
    private final List<Widget> widgets = new ArrayList<Widget>();

    public List<Widget> getWidgets() {
        return Collections.unmodifiableList(widgets);
    }
}