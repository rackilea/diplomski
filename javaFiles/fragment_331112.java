TextView tv = (TextView) findViewById(R.id.test);
tv.setMovementMethod(LinkMovementMethod.getInstance());

SpannableString testText = new SpannableString("This is some text. This is a spoiler and this isn't.");
testText.setSpan(new SpoilerSpan(), 19, 36, Spannable.SPAN_POINT_MARK);

tv.setText(testText, BufferType.SPANNABLE);