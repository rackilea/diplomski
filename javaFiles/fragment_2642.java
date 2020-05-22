@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btnCompute = (Button)findViewById(R.id.button_compute);
    TextView tvAnswer = (TextView)findViewById(R.id.textView_answer);


    btnCompute.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            /*
             * DO COMPUTATION here
            */

            tvAnswer.setText(answer);
        }
    });
}