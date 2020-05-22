//right below TextView final_text; at the top add this
CheckBox checkBox181,checkBox182,checkBox183,checkBoxCM;

//declare then in onCreate()
@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_dessert_ing_avail);

   final_text = (TextView)findViewById(R.id.final_result);
   final_text.setEnabled(false);
   checkBox181=(CheckBox)findViewById(R.id.checkBox181);
   checkBox182=(CheckBox)findViewById(R.id.checkBox182);
   checkBox183=(CheckBox)findViewById(R.id.checkBox183);
   checkBoxCM=(CheckBox)findViewById(R.id.checkBoxCM);
}