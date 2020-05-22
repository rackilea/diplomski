// add username TextView to textWrapper
    TextView usernameText = new TextView(getApplicationContext());
    lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    usernameText.setLayoutParams(lp);
    usernameText.setText(username);
    usernameText.setTextColor(Color.parseColor("#FFFFFF"));
    usernameText.setTextSize(0, (int)    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics()));
    textWrapper.addView(usernameText);`

    // add status TextView to textWrapper
    TextView statusText = new TextView(getApplicationContext());
    lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    statusText.setLayoutParams(lp);
    statusText.setText(status);
    statusText.setTextColor(Color.parseColor("#FFFFFF"));
    statusText.setTextSize(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics()));
    textWrapper.addView(statusText);