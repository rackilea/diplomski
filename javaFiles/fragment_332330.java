EditText editText = findViewById(...);
Button btn = findViewById(...);

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Spannable spannable = new SpannableString(editText.getText().toString());
        spannable.setSpan(new UnderlineSpan(), 
                            editText.getSelectionStart(), // start index
                            editText.getSelectionEnd(), // end index
                            0);
        editText.setText(spannable);
    }
});