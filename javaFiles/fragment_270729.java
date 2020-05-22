public void onCreate(Bundle savedInstanceState) {   
    super.onCreate(savedInstanceState);   
    setContentView(R.layout.gameover);    re_run = (Button) 
    findViewById(R.id.retry);    
    EndScore = (TextView) findViewById(R.id.show);    
    int getVal;    
    getVal = getIntent().getExtras().getInt("number");   
    String s = String.valueOf( getVal );    
    EndScore.setText(s);    
    setButtonOnClickListeners();
    }