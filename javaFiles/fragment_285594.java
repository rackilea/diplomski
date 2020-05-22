public static void log(final String text) {
  // Could be instantiate just once e.g. in onCreate and here just appending
  SpannableStringBuilder ssb = new SpannableStringBuilder(output.getText());
  if (text.contains("500")) {
    ssb.append(coloredText(text + "\n", Color.parseColor("red")));
  } else {
    ssb.append(text).append("\n");
  }
  output.setText(ssb, TextView.BufferType.SPANNABLE);
}


private static SpannableString coloredText(String text, int color) {
  final SpannableString spannableString = new SpannableString(text);
  try {
    spannableString.setSpan(new BackgroundColorSpan(color), 0,
                    text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    } catch (Exception e) {}
    return spannableString;
}