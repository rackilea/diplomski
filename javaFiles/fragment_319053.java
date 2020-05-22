@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LinearLayout mainLinearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams mainLinearLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mainLinearLayout.setLayoutParams(mainLinearLayoutParams);
        mainLinearLayout.setOrientation(LinearLayout.VERTICAL);
        this.setContentView(mainLinearLayout);

        final RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        relativeLayout.setLayoutParams(relativeLayoutParams);
        mainLinearLayout.addView(relativeLayout);

        final Button restartButton = new Button(this);
        restartButton.setText(R.string.restartButton);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        restartButton.setLayoutParams(buttonParams);
        relativeLayout.addView(restartButton);

        ScrollView scrollView = new ScrollView(this);
        mainLinearLayout.addView(scrollView);

        final LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(linearLayoutParams);
        linearLayout.setOrientation(linearLayout.VERTICAL);
        scrollView.addView(linearLayout);

        TextView textView1 = new TextView(this);
        testTitle.setText(R.string.text_view1);
        linearLayout.addView(textView1);

        // + other 10 text views
    }