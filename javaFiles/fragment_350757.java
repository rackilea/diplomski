Intent intent;
    public String date ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        intent =  = getIntent();
        date = intent.getStringExtra("date")
    }
    public String getDate(){
        return date;
    }