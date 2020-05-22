private double number = -1;

public void click (View view) // Note: no longer static.
{
    EditText textIn = (EditText) findViewById(R.id.textIn);
    int givenN = Integer.parseInt(textIn.getText().toString());
    if (number > givenN) {
        System.out.println("Higher");
    } else if (number == givenN){
        System.out.println("Good!");
    } else if (number < givenN) {
        System.out.println("Lower");
    }
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main); 
    number = Math.ceil(Math.random()* 20);
}