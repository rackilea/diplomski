public abstract class BasePage extends WebPage {
    public BasePage() {
        add(new Label("title", new PropertyModel<String>(this, "title")));
    }
    public abstract String getTitle();
}