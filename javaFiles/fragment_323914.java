Button button = (Button) findViewById(R.id.button);
    TextView messageBox = (TextView)findViewById(R.id.message);
    phrase[0] = "Hello World!";  //
    phrase[1] = "Toast";         // array is declared earlier in code
    Random r = new Random();
    int  n = r.nextInt(1);
    messageBox.setText(phrase[0]);

    if(messageBox.getText().toString().equals("Toast")){
       // do stuff
    }