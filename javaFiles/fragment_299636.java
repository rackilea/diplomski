LinearLayout ll = new LinearLayout(this);
ll.setOrientation(LinearLayout.VERTICAL);
TextView label = new TextView(this);
EditText edit = new EditText(this);
LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
     LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
label.setText("My Label");
edit.setText ("My Edit");
ll.addView(label, layoutParams);
ll.addView(edit, layoutParams);
setContentView(ll);