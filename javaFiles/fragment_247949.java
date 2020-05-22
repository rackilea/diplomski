public class ExampleApplication extends Application {

    // note, I remove the inject, you were doing it for testing etc
    private ApplicationComponent appComponent;

    private UrlComponent urlComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        urlComponent = appComponent.plus(new UrlModule("https://jsonplaceholder.typicode.com/"));


    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }

    public UrlComponent getUrlComponent() {
        return urlComponent;
    }


}