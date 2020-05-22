SpannableString WordtoSpan = new SpannableString("This is simple");        
    WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

//0 is starting character and 7 is ending character you need to specify it


  textView.setText(WordtoSpan);