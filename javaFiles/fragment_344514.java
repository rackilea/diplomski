class MyNavigationDelegate implements GeckoSession.NavigationDelegate {
    @Override
    public GeckoResult<AllowOrDeny> onLoadRequest(
            final GeckoSession session,
            final LoadRequest request) {
        // TODO: deny/allow based on your constrains.
    }

    // TODO: You should implement the rest of the delegate to handle page load
    // errors and new session requests triggered by new-tab/window requests.
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    GeckoView view = findViewById(R.id.geckoView);
    GeckoSession session = new GeckoSession();
    GeckoRuntime runtime = GeckoRuntime.create(this);

    session.setNavigationDelegate(new MyNavigationDelegate());

    session.open(runtime);
    view.setSession(session);
    session.loadUri("https://www.google.com");
}