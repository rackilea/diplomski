public class NannyApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * applicationInjector() gets called inside onCreate()
     */
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerNannyApplicationComponent
                .builder()
                .create(this);
    }
}