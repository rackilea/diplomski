TextView text = (TextView)findViewById(R.id.text);

String simple = "First Name ";
String colored = "*";
SpannableStringBuilder builder = new SpannableStringBuilder();

builder.append(simple);
int start = builder.length();
builder.append(colored);
int end = builder.length();

builder.setSpan(new ForegroundColorSpan(Color.RED), start, end, 
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

text.setHint(builder);