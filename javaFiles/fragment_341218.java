....

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    setContentView(R.layout.activity_show_info); 
    PlaceholderFragment fragment = new PlaceholderFragment();
    fragment.setArguments(intent.getExtras());
    if (savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction()
        .add(R.id.container, fragment).commit();
    }
}