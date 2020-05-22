public CharSequence getFormattedQuestion(Context context, String originalQues, @ColorRes int colorToSet, @DimenRes int textSize) {

    // First we check if the question has the expression
    if (originalQues == null || !originalQues.contains("{") || !originalQues.contains("}")) {
        return originalQues;
    }

    // Then we break the original text into parts

    int startIndex = originalQues.indexOf("{");
    int endIndex = originalQues.indexOf("}");

    // 1) The text before the expression
    String leftPart = startIndex>0 ? originalQues.substring(0, startIndex) : "";

    // 2) The text after the expression (if there is any)
    String rightPart = endIndex == originalQues.length()-1 ? "" : originalQues.substring(endIndex+1);

    // 3) The expression text
    String midPart = originalQues.substring(startIndex+1, endIndex);

    // 4) Format the mid part with the give color (colorToSet) and size (textSize)
    SpannableString spannableMid = new SpannableString(midPart);
    spannableMid.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, colorToSet)), 0, midPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    spannableMid.setSpan(new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(textSize)), 0, midPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


    // check if there is any left part; if so, add it with mid
    CharSequence leftAndMid = leftPart.length()>0 ? TextUtils.concat(leftPart, " ", spannableMid) : spannableMid;

    // Check if there is any right part else return the left and mid
    return rightPart.length()>0 ? TextUtils.concat(leftAndMid, " ", rightPart) : leftAndMid;
}