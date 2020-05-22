private static final Insets LABEL_PADDING = new Insets(25, 30, 25, 30);

private static Label createLabel(String text) {
    Label label = new Label(text);
    label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    label.setPadding(LABEL_PADDING);
    return label;
}