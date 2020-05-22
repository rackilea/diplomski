public class AppleMenus implements com.apple.eawt.OpenURIHandler {

    private MyApp myApp;

    public AppleMenus(MyApp myApp) {
        this.myApp = myApp;
        final com.apple.eawt.Application app = com.apple.eawt.Application.getApplication();
        app.setOpenURIHandler(this);
    }

    @Override
    public void openURI(final com.apple.eawt.AppEvent.OpenURIEvent oue) {
        myApp.openCustomURL(oue.getURI());
    }
}