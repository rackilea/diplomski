public double mTotal;
    private TextView mTextView;

    private EditText[] mQuantityEditTexts = new EditText[5];
    private EditText[] mPriceEditTexts = new EditText[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.txtExample);

        mQuantityEditTexts[0] = (EditText) findViewById(R.id.editQuantity);
        mQuantityEditTexts[1] = (EditText) findViewById(R.id.editQuantity2);
        mQuantityEditTexts[2] = (EditText) findViewById(R.id.editQuantity3);
        mQuantityEditTexts[3] = (EditText) findViewById(R.id.editQuantity4);
        mQuantityEditTexts[4] = (EditText) findViewById(R.id.editQuantity5);

        mPriceEditTexts[0] = (EditText) findViewById(R.id.editPrice);
        mPriceEditTexts[1] = (EditText) findViewById(R.id.editPrice2);
        mPriceEditTexts[2] = (EditText) findViewById(R.id.editPrice3);
        mPriceEditTexts[3] = (EditText) findViewById(R.id.editPrice4);
        mPriceEditTexts[4] = (EditText) findViewById(R.id.editPrice5);

        for (int i = 0; i < 5; i++) {
            mQuantityEditTexts[i].addTextChangedListener(mTextWatcher);
            mPriceEditTexts[i].addTextChangedListener(mTextWatcher);
        }
    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }


        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            calc();
        }


        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public void calc()
    {
        try {
            for (int i = 0; i <= 4; i++)
                mTotal += Integer.parseInt(mQuantityEditTexts[i].getText().toString()) *
                        Double.parseDouble(mPriceEditTexts[i].getText().toString());

            String str = Double.toString(mTotal);
            mTextView.setText(str);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "WTF! Enter valid numbers!", Toast.LENGTH_SHORT).show();
        }
    }