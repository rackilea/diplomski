@Override  
public void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);  
    setContentView(R.layout.order);  
    txtbox1= (EditText) findViewById(R.id.editText1);  
    button1 = (Button) findViewById(R.id.button1);  
    tv = (TextView) findViewById(R.id.editText5);  
    txtbox2= (EditText) findViewById(R.id.editText2);
    check1 = (CheckBox)findViewById(R.id.checkcheck);
    button1.setOnClickListener(new clicker());
    check1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView,
            boolean isChecked) {
            if (isChecked) {
                txtbox1.setEnabled(false);
            } else {
                txtbox1.setEnabled(true);
            }
        }
    });

    button1.setOnClickListener(new OnClickListener(){

        @Override
        public void onClick(View v) {
            String a,b;  
            Integer vis;
            a = txtbox1.getText().toString();  
            b = txtbox2.getText().toString();  
            vis = Integer.parseInt(a)*2+Integer.parseInt(b)*3;  
            tv.setText(vis.toString());  
        }         
    });

    // This will make sure the user can only type numbers into the EditTexts:
    txtbox1.setInputType(InputType.TYPE_CLASS_NUMBER);
    txtbox2.setInputType(InputType.TYPE_CLASS_NUMBER);

    // Code to disable editTexts at start once:
    txtbox1.setEnabled(false);
    txtbox2.setEnabled(false);
}