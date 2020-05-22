SpannableStringBuilder resultSpan = new SpannableStringBuilder(yourString);

for (int i = 0; i < resultSpan.length(); i++) {
  if (resultSpan.charAt(i) == '\u0180') {
    CustomTypefaceSpan typefaceSpan = new CustomTypefaceSpan(customTypeface);
    resultSpan.setSpan(typefaceSpan, i, i + 1, 0);
  }
}