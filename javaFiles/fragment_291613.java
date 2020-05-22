public class Demo extends Activity {
    TextView textSavedMem1, textSavedMem2;
    Button buttonSaveMem1, buttonSaveMem2;
    EditText editText1, editText2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textSavedMem1 = (TextView)findViewById(R.id.savedmem1);
        textSavedMem2 = (TextView)findViewById(R.id.savedmem2);
        editText1 = (EditText)findViewById(R.id.edittext1);
        editText2 = (EditText)findViewById(R.id.edittext2);
        buttonSaveMem1 = (Button)findViewById(R.id.save_mem1);
        buttonSaveMem2 = (Button)findViewById(R.id.save_mem2);

        buttonSaveMem1.setOnClickListener(buttonSaveMem1OnClickListener);
        buttonSaveMem2.setOnClickListener(buttonSaveMem2OnClickListener);

        Button buttonStartAnother = (Button)findViewById(R.id.startanother);
        buttonStartAnother.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub              
            }   
        });
    }       
    public void myMethod() {
        buttonSaveMem2.setText("myMethod called");
            // buttonSaveMem2 is accessible here because it is declared globally
        // buttonStartAnother.setText("hello");
            // If you remove comment on above line you will get error
            // because buttonStartAnother is invisible to this method
    }
}