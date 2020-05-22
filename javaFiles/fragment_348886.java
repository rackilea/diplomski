@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);

    LinearLayout main_layout = (LinearLayout)findViewById(R.id.tileContainerME);
    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    LinearLayout child = (LinearLayout) inflater.inflate(R.layout.main_layout, null);
    main_layout.addView(child, 1);
}