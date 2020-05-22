class TextFieldStatusManipulator {
    private final Function<Model,String> extractString;
    private final Predicate<Status> setVisible;
    private final TextBox textBox;
    public TextFieldStatusManipulator(TextBox box, Function<Model,String> ex, Predicate<Status> sv) {
        textBox = box; extractString = ex; setVisible = sv;
    }
    public void statusChange(Model model) {
        textBox.setText(extractString.apply(model));
        textBox.setVisible(setVisible.test(model.status));
    }
}