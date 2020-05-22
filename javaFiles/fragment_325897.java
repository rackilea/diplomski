public static String text = "123";
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txt = findViewById(R.id.txt);
         txt.setText(text);

    }

    public TextView getTxt() {
        return txt;
    }
}