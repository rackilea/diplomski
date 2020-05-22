LinearLayout mainLayout = new LinearLayout(this);
mainLayout.setOrientation(LinearLayout.VERTICAL);

LinearLayout menuLayout = new LinearLayout(this);
menuLayout.setOrientation(LinearLayout.HORIZONTAL);

TextView textView = new TextView(this);
Button button = new Button(this);
Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

menuLayout.addView(textView);
menuLayout.addView(button);
menuLayout.addView(spinner2);

mainLayout.addView(menuLayout);