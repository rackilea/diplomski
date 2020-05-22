LinearLayout view = (LinearLayout)LayoutInflater.from(this).inflate(R.layout.my_button, null);
// or LinearLayout buttonView = (LinearLayout)this.getLayoutInflater().inflate(R.layout.my_button, null);
Button myButton = (Button) view.findViewById(R.id.myButton);
view.removeView(myButton);

LinearLayout mainView = (LinearLayout)this.findViewById(R.id.mainLayout);
mainView.addView(myButton);