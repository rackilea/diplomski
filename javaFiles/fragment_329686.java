private EditText text = (EditText)findViewById(R.id.text);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text.setOnKeyListener(new TextMaker());
    }