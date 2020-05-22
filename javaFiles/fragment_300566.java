TextView myTextView = new TextView(this);
    String myString = "Some text [clickable]";
    int i1 = myString.indexOf("[");
    int i2 = myString.indexOf("]");
    myTextView.setMovementMethod(LinkMovementMethod.getInstance());
    myTextView.setText(myString, BufferType.SPANNABLE);
    Spannable mySpannable = (Spannable)myTextView.getText();
    ClickableSpan myClickableSpan = new ClickableSpan()
    {
     @Override
     public void onClick(View widget) { /* do something */ }
    };
    mySpannable.setSpan(myClickableSpan, i1, i2 + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);