public class Commons {
    public static void makeTextViewSpannable(TextView tv, String text, int startIndex, int endIndex, MyClickableSpan span) {
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(span, startIndex, endIndex, 0);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setText(spannableString, TextView.BufferType.SPANNABLE);
    }
}