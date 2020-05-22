public class MainActivity extends AppCompatActivity {

EditText et1, et2, et3, et4, et5;
boolean firsEditText, secondEditText, thirdEditText,  fourthEditText, fifthEditText;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    et1 = (EditText) findViewById(R.id.et1);
    et2 = (EditText) findViewById(R.id.et2);
    et3 = (EditText) findViewById(R.id.et3);
    et4 = (EditText) findViewById(R.id.et4);
    et5 = (EditText) findViewById(R.id.et5);

    et1.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() > 0) {
                firsEditText = true;
                if (checkAllTrue())
                    et5.setEnabled(true);
            } else {
                firsEditText = false;
                et5.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });

    et2.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() > 0) {
                secondEditText = true;
                if (checkAllTrue())
                    et5.setEnabled(true);
            } else {
                secondEditText = false;
                et5.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });

    et3.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() > 0) {
                thirdEditText = true;
                if (checkAllTrue())
                    et5.setEnabled(true);
            } else {
                thirdEditText = false;
                et5.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });

    et4.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.toString().length() > 0) {
                fourthEditText = true;
                if (checkAllTrue())
                    et5.setEnabled(true);
            } else {
                fourthEditText = false;
                et5.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });


}

private boolean checkAllTrue() {
    if (firsEditText && secondEditText && thirdEditText && fourthEditText)
        return true;
    return false;
}