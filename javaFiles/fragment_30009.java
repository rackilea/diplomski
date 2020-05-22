LinearLayout mLayout = (LinearLayout) findViewById(R.id.myLayout);
    LayoutParams p = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
    RadioButton mRadioButton = new RadioButton(this);
    mRadioButton.setLayoutParams(p);
    mLayout.addView(mRadioButton);

    p = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
    RelativeLayout mRelativeLayout = new RelativeLayout(this);
    mRelativeLayout.setLayoutParams(p);
    mLayout.addView(mRelativeLayout);