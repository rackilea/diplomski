@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();

    if (isUserValid) {
        ft.replace(R.id.content, new LoggingFragment(), "loggingFragment");
    } else {
        ft.replace(R.id.content, new MainFragment(), "mainFragment");
    }
    ft.commit();
}