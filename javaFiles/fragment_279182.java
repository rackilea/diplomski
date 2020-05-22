String[] texts = {editText1, editText2, editText3, editText4, editText5};

    int ints[]=new int[texts.length];
    int sum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextSum = findViewById(R.id.txt_sum);
        for (int i = 0; i < 5; i++) {
            ints[i] = Integer.parseInt(texts[i]);
            Log.e("ints[i]", String.valueOf(ints[i]));
            sum=sum+ints[j];
        }
        mTextSum.setText(String.valueOf(sum));
    }