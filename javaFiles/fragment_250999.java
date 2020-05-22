RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
TextView textView = (TextView) findViewById(R.id.textView);
RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

//Choose only one of the following.

//Add this if you want your myText be below textView.
params.addRule(RelativeLayout.BELOW, textView);

//Add this if you want to align your myText to the bottom of the screen.
params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

TextView myText= new TextView(this);
myText.setLayoutParams(params);
myText.setText("Some Text");
relativeLayout.addView(myText);