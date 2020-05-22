final CheckedTextView check1 = new CheckedTextView(getApplicationContext());
    check1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    check1.setId(fieldNo);
    check1.setCheckMarkDrawable(android.R.drawable.checkbox_off_background);
    check1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (check1.isChecked()){
                check1.setChecked(false);
                check1.setCheckMarkDrawable(android.R.drawable.checkbox_off_background);
            }else{
                check1.setChecked(true);
                check1.setCheckMarkDrawable(android.R.drawable.checkbox_on_background);
            }
        }
    });
    check1.setTextColor(Color.BLACK);
    check1.setGravity(Gravity.LEFT);
    check1.setText(formField.get(fieldNo));