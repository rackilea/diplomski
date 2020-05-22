TextView tv;
Button myButton;
EditText et;

onCreate():

tv = (TextView)findViewById(R.id.textview);
myButton = (Button)findViewById(R.id.button);
et = (EditText)findViewById(R.id.edittext);

//Now set the onclick listener:
myButton.setOnClickListener(new Button.OnClickListener() {
public void onClick(args....) 
{
    String txt = et.getText().toString();
    tv.setText(txt);
}
});