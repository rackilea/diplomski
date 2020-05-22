private LinearLayout mEditTextContainer;

@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    mEditTextContainer = (LinearLayout)findViewById(R.id.linearLayoutDecisions);
    ...
}

public void addLine() {
    // add edittext
    EditText et = new EditText(this);
    LinearLayout.LayoutParams p = new
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
    et.setLayoutParams(p);
    et.setText("Enter Answer #" + (mEditTextContainer.getChildCount()+1));
    mEditTextContainer.addView(et);
    Toast.makeText(MainActivity.this, "1", Toast.LENGTH_LONG).show();
}

public void removeLine() {
    mEditTextContainer.removeViewAt(mEditTextContainer.getChildCount()-1);
}