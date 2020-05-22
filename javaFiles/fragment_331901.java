// LINEAR LAYOUT
LinearLayout layout = new LinearLayout(getApplicationContext());
layout.setOrientation(LinearLayout.VERTICAL);
setContentView(layout);

// TEXTVIEW
LinearLayout.LayoutParams paramstv = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,1f);
tv.setLayoutParams(paramstv);
layout.addView(tv);

// EDITTEXT
et.setGravity(Gravity.BOTTOM);
et.setInputType(InputType.TYPE_CLASS_TEXT);

LinearLayout.LayoutParams etparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,8f);
etparams.gravity = Gravity.BOTTOM;
et.setLayoutParams(etparams);
layout.addView(et);