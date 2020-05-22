public class WicketApplication extends WebApplication {
    @Override
    protected void init() {
        super.init();
        mountPage("home", getHomePage());
        mountPage("secret", SecretPage.class);
    }
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }
}