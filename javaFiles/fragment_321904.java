...
Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
EditText focusedView;
EditText etInput1, etInput2;
...

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // finding the EditTexts and Buttons with findViewById(), I am skipping that portion

    etInput1.setOnFocusChangeListener(focusListener);
    etInput2.setOnFocusChangeListener(focusListener);

    btn1.setOnClickListener(onClickListener);
    btn2.setOnClickListener(onClickListener);
    btn3.setOnClickListener(onClickListener);
    btn4.setOnClickListener(onClickListener);
    btn5.setOnClickListener(onClickListener);
    btn6.setOnClickListener(onClickListener);
    btn7.setOnClickListener(onClickListener);
    btn8.setOnClickListener(onClickListener);
    btn9.setOnClickListener(onClickListener);
    btn0.setOnClickListener(onClickListener);

}

public View.OnClickListener onClickListener = new View.OnClickListener(){
    public void onClick(View view){
        focusedView.append((Button)view).getText());
    }
}

private OnFocusChangeListener focusListener = new OnFocusChangeListener() {
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){
             focusedView = (EditText)v;
        } else {
             focusedView  = null;
        }
    }
}