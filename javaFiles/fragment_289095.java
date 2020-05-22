String stringRandValue = Integer.toString(randValue);
View relativeLayout =  findViewById(R.id.activity_display_num);;
TextView textView = new TextView(this);
textView.setTextSize(30);
textView.setText(stringRandValue);
((RelativeLayout)relativeLayout).addView(textView);