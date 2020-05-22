public class HomePage extends WebPage {
    public HomePage(final PageParameters parameters) {
        add(new BookmarkablePageLink<Void>("bookmarkable", SecretPage.class,
            new PageParameters().add("message", "This message will appear in the URL")));
        add(new Link<Void>("instance") {
            @Override
            public void onClick() {
                setResponsePage(new SecretPage("This message will NOT appear in the URL"));
            }
        });
    }
}