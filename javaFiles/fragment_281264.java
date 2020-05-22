@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_igra);
    Intent data = getIntent();
    ArrayList<String> players = data.getStringArrayListExtra("players");
}