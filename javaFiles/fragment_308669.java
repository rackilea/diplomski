public class SomeActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(...)
        editText = findViewById(R.id.some_edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s) || s.charAt(0) != ' '){
                    editText.removeTextChangedListener(this);
                    s.insert(0, " ");
                    editText.addTextChangedListener(this);
                }
            }
        });
    }
}