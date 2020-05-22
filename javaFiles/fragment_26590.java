public void Add_Line() {
    LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayoutDecisions);
    // add edittext
    EditText et = new EditText(this);
    LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    et.setLayoutParams(p);
    et.setText("Text");
    et.setId(numberOfLines + 1);
    ll.addView(et);
    numberOfLines++;
}