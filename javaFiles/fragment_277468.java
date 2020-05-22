public class MainActivity extends Activity { 

            Button submit;
            EditText ET;
            TextView output;
            String words[]={"one","two","three","four","five"};

            @override 
            protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            submit = (Button) findViewById(R.id.SubmitBTN);
            ET = (EditText) findViewById(R.id.editText1);
            output = (TextView) findViewById(R.id.textView1);

            Submit.setOnClickListener(new OnClickListener(){ 

            int num = Integer.parseInt(ET.getText().toString());
            if(num<5)
            output.setText(words[num+1]); 


                     }); 
                 } 
            }