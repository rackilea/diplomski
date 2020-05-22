protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_play_game);

    TextView dateView = (TextView)findViewById(R.id.date_Text_View);
    setDate(dateView);
}

public void setDate (TextView view){
    String str = String.format("%tc", new Date());
    view.setText("The date is " + str);
}