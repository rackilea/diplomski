public class MainActivity extends Activity {
 EditText name1;
  EditText marks1;
 private ListView lv;
 ArrayAdapter<String> aa;
 ArrayList<String> data = new ArrayList<String>();
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState); 
 requestWindowFeature(Window.FEATURE_NO_TITLE);
 getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
    WindowManager.LayoutParams.FLAG_FULLSCREEN);
setContentView(R.layout.activity_main);

TextView markshee = (TextView)findViewById(R.id.textView3); 
markshee.setText("");

Button btnAdd = (Button) findViewById(R.id.button1);
btnAdd.setOnClickListener(new Button.OnClickListener() {

    public void onClick(View v) {

        try{
            name1 = (EditText)findViewById(R.id.editText1);   
             String name = name1.getText().toString();

            marks1 = (EditText)findViewById(R.id.editText2);   
            String marks = marks1.getText().toString();


            if(name.equals("") || marks.equals("")){

                String str="Don't Leave any field blank !";

                Toast toast = Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
               }
               else { 

                    TextView marksheet = (TextView)findViewById(R.id.textView3); 
                    marksheet.setText("Marks Sheet");
                    marksheet.setTextColor(Color.BLUE);

                    TextView nam = (TextView)findViewById(R.id.textView4); 
                    nam.setText("Name");
                    nam.setTextColor(Color.RED);

                    TextView mar = (TextView)findViewById(R.id.textView5); 
                    mar.setText("Marks");
                    mar.setTextColor(Color.RED);

                name1.setText("");
                marks1.setText("");

                lv = (ListView) findViewById(R.id.listView1);
                lv.setItemsCanFocus(true);


                 data.add("  "+name+"                         "+marks);


                 aa =      
                 new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, data);

                 lv.setAdapter(aa); 

               }
            }catch(Exception ex)
            {
                System.out.println(ex.getStackTrace());
            }
     }
});

}