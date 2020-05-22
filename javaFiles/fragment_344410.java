TextView txtDisplay;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    txtDisplay = (TextView) findViewById(R.id.txtDisplay);
    findViewById(R.id.btnTan).setOnClickListener(this);
}

@Override
public void onClick(View v) {
    if (v.getId() == R.id.btnTan) {
        double value = Double.parseDouble(txtDisplay.getText().toString());
        if (value % 180 != 0 && value % 90 == 0) 
            txtDisplay.setText("undefined");
        else {
            value = Math.round(Math.tan(Math.toRadians(value)));
            txtDisplay.setText(String.valueOf(value));
        }
    }
}