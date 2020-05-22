public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_container);

    if (findViewById(R.id.fraContainer) != null) 
    {
        MyFragmentA myFragment = new MyFragmentA();        
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fraContainer, myFragment)
                .commit();
    }
}