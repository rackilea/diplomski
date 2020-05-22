public class Theme {

    private final ObjectProperty<Color> base = new SimpleObjectProperty<>(Color.web("#ececec"));
    private final ObjectProperty<Color> accent = new SimpleObjectProperty<>(Color.web("#0096c9"));
    private final ObjectProperty<Color> defaultButton = new SimpleObjectProperty<>(Color.web("#abd8ed"));
    private final ObjectProperty<Color> focusColor = new SimpleObjectProperty<>(Color.web("#039ed3"));
    private final ObjectProperty<Color> faintFocusColor = new SimpleObjectProperty<>(Color.web("039ed322"));

    public ObjectProperty<Color> baseProperty() {
        return base ;
    }

    public final Color getBase() {
        return baseProperty().get();
    }

    public final void setBase(Color base) {
        baseProperty().set(base);
    }

    // etc etc

    private final ReadOnlyStringWrapper css = new ReadOnlyStringWrapper() ;

    public Theme() {
        css.bind(Bindings.createStringBinding(() -> String.format(
             "-fx-base: %s; "
            +"-fx-accent: %s; "
            +"-fx-default-button: %s; "
            +"-fx-focus-color: %s ; "
            +"-fx-faint-focus-color: %s ;",
            toRgba(getBase()),
            toRgba(getAccent()),
            toRgba(getDefaultButton()),
            toRgba(getFocusColor()),
            toRgba(getFaintFocusColor())),
            base, accent, defaultButton, focusColor, faintFocusColor));
    }

    private String toRgba(Color color) {
        int r = (int) (255 * color.getRed());
        int g = (int) (255 * color.getGreen());
        int b = (int) (255 * color.getBlue());
        int a = (int) (255 * color.getOpacity());
        return String.format("#%02x%02x%02x%02x", r, g, b, a);
    }

    public ReadOnlyStringProperty cssProperty() {
        return css.getReadOnlyProperty();
    }

}