public static Spanned removeImageSpanObjects(String inStr) {
    SpannableStringBuilder spannedStr = (SpannableStringBuilder) Html
            .fromHtml(inStr.trim());
    Object[] spannedObjects = spannedStr.getSpans(0, spannedStr.length(),
            Object.class);
    for (int i = 0; i < spannedObjects.length; i++) {
        if (spannedObjects[i] instanceof ImageSpan) {
            ImageSpan imageSpan = (ImageSpan) spannedObjects[i];
            spannedStr.replace(spannedStr.getSpanStart(imageSpan),
                    spannedStr.getSpanEnd(imageSpan), "");
        }
    }
    return spannedStr;
}