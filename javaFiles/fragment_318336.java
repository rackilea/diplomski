public class Result extends AppCompatActivity {

    TextView tim;

    Canvas canvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        canvas = new Canvas(this);
        setContentView(R.layout.activity_result);
        //setContentView(canvas);

        Intent variables = getIntent();
        //int length = variables.getIntExtra("varLength",0);
        //int width =variables.getIntExtra("varWidth",0);
        int totalResult = variables.getIntExtra("varResult",0);

        String result = String.valueOf(totalResult);

        tim = findViewById(R.id.txtResult);
        tim.setText(result);
    }