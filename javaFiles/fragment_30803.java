...

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_b);
    boolean isAnswerCorrect = getIntent().getBooleanExtra("isAnswerCorrect", false);
    if (isAnswerCorrect) {
        next_level_btn.setVisibility(View.VISIBLE);
    } else {
        next_level_btn.setVisibility(View.GONE);
    }
}

...