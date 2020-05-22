String display1;
double displayValue;

     @Override
        public  void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            display= (EditText) findViewById(R.id.editText1);

        if(display.length()!=0){
          display1= display.getText().toString();
          displayValue= Double.parseDouble(display1);
          }

        }