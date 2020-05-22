SpannableStringBuilder builder = new SpannableStringBuilder();

String red = "this is red";
SpannableString redSpannable= new SpannableString(red);
redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, red.length(), 0);
builder.append(redSpannable);

String white = "this is white";
SpannableString whiteSpannable= new SpannableString(white);
whiteSpannable.setSpan(new ForegroundColorSpan(Color.WHITE), 0, white.length(), 0);
builder.append(whiteSpannable);

String blue = "this is blue";
SpannableString blueSpannable = new SpannableString(blue);
blueSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, blue.length(), 0);
builder.append(blueSpannable);

mTextView.setText(builder, BufferType.SPANNABLE);