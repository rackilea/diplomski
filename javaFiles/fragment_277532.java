public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.etEmail);
       // editText.setSelectAllOnFocus(true); --> Select all text inside EditText when it gets focus
    }

    public void Clickhandle(View view) {
        editText.requestFocus();
        editText.selectAll();
        editText.post(new Runnable() {
            public void run() {
                editText.scrollTo(0, 0);
            }
        });
    }
}