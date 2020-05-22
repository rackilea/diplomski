private Button refresh;
private TextView Tv;
private TextView Tv2;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    refresh = (Button)findViewById(R.id.btn1);
    Tv = (TextView)findViewById(R.id.TV);
    Tv2 = (TextView)findViewById(R.id.Tv2);

    refresh.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        displayer();            //Call method "displayer" when user presses button
    }
});

private void displayer() {
    String date = sdf.format(calendar.getTime());
    Tv.setText("The current time is "+date);
    String str=date.charAt(0)+""+date.charAt(1)+""+date.charAt(3)+""+date.charAt(4);
    Tv2.setText("So the password will be " + str);
}