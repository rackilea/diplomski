RelativeLayout rLayout = (RelativeLayout) findViewById(R.id.rlayout);
RelativeLayout.LayoutParams lprams = new RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT);
Button tv1 = new Button(this);
tv1.setText("Hello");
tv1.setLayoutParams(lprams);
tv1.setId(1);
rLayout.addView(tv1);

// second Button
RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT);
Button tv2 = new Button(this);
tv1.setText("Hello2");
newParams.addRule(RelativeLayout.RIGHT_OF, 1);
tv2.setLayoutParams(newParams);
tv2.setId(2);
rLayout.addView(tv2);