private SpannableString addClickablePart(String str) {
    SpannableString ss = new SpannableString(str);
    Pattern pattern = Pattern.compile("[@]\\w*");
    Pattern matcher = pattern.matcher(str);

    while (matcher.find()) {
      ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View textView) {
            // do toasting
        }
      };
      ss.setSpan(clickableSpan, matcher.start, matcher.end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    return ss;
}