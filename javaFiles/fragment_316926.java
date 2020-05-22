class MyApp extends Application {
...

    public static MyApp context;
    ...

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        ... set up global data here ...
    }
...
}