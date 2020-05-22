protected void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    background = (LinearLayout) findViewById(R.id.layout); //here is the error
    myButton = (Button) findViewById(R.id.myButton);
    myButton.setOnClickListener(new View.OnClickListener() { 
        @Override 
        public void onClick(View view) {
            background.setBackgroundColor(Color.parseColor("#00aa00")); 
        } 
    }); 
}