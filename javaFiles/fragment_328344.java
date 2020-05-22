public class SecretPage extends WebPage {
    public SecretPage(PageParameters parameters) {
        super(parameters);
        init(parameters.get("message").toString("No message!"));
    }
    public SecretPage(String message) {
        // super(new PageParameters().add("message", message)); // COMMENTED!
        init(message);
    }
    private void init(String message) {
        info(message);
        add(new FeedbackPanel("feedback"));
        add(new BookmarkablePageLink<Void>("back", getApplication().getHomePage()));
    }
}