String myString = "Hello How Are You"; 
String hello = "Hello";
SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(myString);
spannableStringBuilder.setSpan(
   new MyClickableSpannable(hello), startIndexOfHello,
   startIndexOfHello + hello.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);