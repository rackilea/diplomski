protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    txtDisplay = (TextView) findViewById(R.id.txtDisplay);
    txtDisplay.setText("0");
}

public void shownum(String num) {
    if (clear_flag == 1) {
        txtDisplay.setText("");
        clear_flag = 0;
    }
    else if (txtDisplay.getText() == "0") {
        txtDisplay.setText("");
    }
    Integer lCurrentValue = Integer.valueOf(txtDisplay.getText().toString());
    Integer lNewValue = Integer.valueOf(num);
    txtDisplay.setText(lCurrentValue+lNewValue);
}