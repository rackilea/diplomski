Button b = new Button(this);
    b.setText("Button added dynamically!");
    b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    b.setId(MY_BUTTON);
    b.setOnClickListener(this);
    ll.addView(b);