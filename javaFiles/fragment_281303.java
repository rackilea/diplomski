@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button button1 = (Button) findViewById(R.id.btPrincipal1);
    Button button2 = (Button) findViewById(R.id.btPrincipal2);

    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Bundle bundle = new Bundle();
            bundle.putString(COLOR_PARAM, "green");
            supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor, YourFragment.newInstance("Button1"))
                    .commit();
        }
    });

    button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Bundle bundle = new Bundle();
            bundle.putString(COLOR_PARAM, "red");
            supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor,  YourFragment.newInstance("Button2"))
                    .commit();
        }
    });
}