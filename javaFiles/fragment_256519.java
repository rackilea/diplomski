/** Patch for the String.replace(CharSequence target, CharSequence replacement),
 *  because the original is buggy when CharSequence target is empty, i.e. "".
 *  Patched by Google Android: https://android-review.googlesource.com/58393
 */
public static String replacePatched(final String string, final CharSequence target, final CharSequence replacement) {
    if (target == null) {
        throw new NullPointerException("target == null");
    }
    if (replacement == null) {
        throw new NullPointerException("replacement == null");
    }

//    String targetString = target.toString();                                    // original
    final String targetString = target.toString();
//    int matchStart = indexOf(targetString, 0);                                  // original
    int matchStart = string.indexOf(targetString, 0);
    if (matchStart == -1) {
        // If there's nothing to replace, return the original string untouched.
//        return this;                                                            // original
        return new String(string);
    }

    final char[] value = string.toCharArray();                              // required in patch
    final int count = value.length;                                         // required in patch

//    String replacementString = replacement.toString();                          // original
    final String replacementString = replacement.toString();

    // The empty target matches at the start and end and between each character.
//    int targetLength = targetString.length();                                   // original
//    if (targetLength == 0) {                                                    // original
    if (targetString.length() == 0) {
//        int resultLength = (count + 2) * replacementString.length();            // original
//        // The result contains the original 'count' characters, a copy of the
//        // replacement string before every one of those characters, and a final
//        // copy of the replacement string at the end.
//        int resultLength = count + (count + 1) * replacementString.length();    // patched by Google Android
//        StringBuilder result = new StringBuilder(resultLength);                 // original
        final StringBuilder result = new StringBuilder(count + (count + 1) * replacementString.length());
        result.append(replacementString);
//        for (int i = offset; i < count; ++i) {                                  // original
//        int end = offset + count;                                               // patched by Google Android
//        for (int i = offset; i != end; ++i) {                                   // patched by Google Android
        for (int i = 0; i < count; ++i) {
            result.append(value[i]);
            result.append(replacementString);
        }
//        return result.toString();                                               // original
        return new String(result);      // StringBuilder.toString() does not give exact length
    }

//    StringBuilder result = new StringBuilder(count);                            // original
    final StringBuilder result = new StringBuilder(count);
    int searchStart = 0;
    do {
        // Copy characters before the match...
//        result.append(value, offset + searchStart, matchStart - searchStart);   // original
        result.append(value, searchStart, matchStart - searchStart);
        // Insert the replacement...
        result.append(replacementString);
        // And skip over the match...
//        searchStart = matchStart + targetLength;                                // original
        searchStart = matchStart + targetString.length();
//    } while ((matchStart = indexOf(targetString, searchStart)) != -1);          // original
    } while ((matchStart = string.indexOf(targetString, searchStart)) != -1);
    // Copy any trailing chars...
//    result.append(value, offset + searchStart, count - searchStart);            // original
    result.append(value, searchStart, count - searchStart);
//    return result.toString();                                                   // original
    return new String(result);          // StringBuilder.toString() does not give exact length
}