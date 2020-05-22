public class MainActivity extends AppCompatActivity {


    EditText edtOne, edtTwo, edtThree, edtFour;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtOne = findViewById(R.id.edtOne);
        edtTwo = findViewById(R.id.edtTwo);
        edtThree = findViewById(R.id.edtThree);
        edtFour = findViewById(R.id.edtFour);

        tvResult = findViewById(R.id.tvResult);

        edtOne.addTextChangedListener(textWatcher);
        edtTwo.addTextChangedListener(textWatcher);
        edtThree.addTextChangedListener(textWatcher);
        edtFour.addTextChangedListener(textWatcher);

    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            if (!TextUtils.isEmpty(edtOne.getText().toString().trim())
                    || !TextUtils.isEmpty(edtTwo.getText().toString().trim())
                    || !TextUtils.isEmpty(edtThree.getText().toString().trim())
                    || !TextUtils.isEmpty(edtFour.getText().toString().trim())
                    ) {


                int answer = Integer.parseInt(edtOne.getText().toString().trim()) +
                        Integer.parseInt(edtTwo.getText().toString().trim()) +
                        Integer.parseInt(edtThree.getText().toString().trim()) +
                        Integer.parseInt(edtFour.getText().toString().trim());

                Log.e("RESULT", String.valueOf(answer));
                tvResult.setText(String.valueOf(answer));
            }else {
            tvResult.setText("");
        }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

}