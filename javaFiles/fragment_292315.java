public class ApplicationViewState {

    private final ObjectProperty<Node> menu = new SimpleObjectProperty<>();
    private final ObjectProperty<Node> content = new SimpleObjectProperty<>();

    public ObjectProperty<Node> menuProperty() {
        return menu ;
    }

    public final Node getMenu() {
        return menuProperty().get();
    }

    public final void setMenu(Node menu) {
        menuProperty().set(menu);
    }


    public ObjectProperty<Node> contentProperty() {
        return content ;
    }

    public final Node getContent() {
        return contentProperty().get();
    }

    public final void setContent(Node content) {
        contentProperty().set(content);
    }

    // ...
}