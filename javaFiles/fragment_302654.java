class MyApp extends Application {
    public final Constants constants;

    public void onCreate() {
        constants = new Constants(this);
    }
}