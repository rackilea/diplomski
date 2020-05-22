ConstraintLayout main = (ConstraintLayout) findViewById(R.id.mainLayout);
     ConstraintSet set = new ConstraintSet();

     LinearLayout linearLayout = new LinearLayout(MainActivity.this);
     LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
     linearLayout.setLayoutParams(params);
     linearLayout.setOrientation(LinearLayout.HORIZONTAL);
     linearLayout.setBackgroundColor(Color.RED);
     main.addView(linearLayout,0);
     set.clone(main);
     set.connect(linearLayout.getId(), ConstraintSet.TOP, main.getId(), ConstraintSet.TOP, 60);
     set.applyTo(main);