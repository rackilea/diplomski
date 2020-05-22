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

    final String targetString = target.toString();
    int matchStart = string.indexOf(targetString, 0);
    if (matchStart == -1) {
        // If there's nothing to replace, return the original string untouched.
        return new String(string);
    }

    final char[] value = string.toCharArray();                              // required in patch
    final int count = value.length;                                         // required in patch

    final String replacementString = replacement.toString();

    // The empty target matches at the start and end and between each character.
    if (targetString.length() == 0) {
        // The result contains the original 'count' characters, a copy of the
        // replacement string before every one of those characters, and a final
        // copy of the replacement string at the end.
        final StringBuilder result = new StringBuilder(count + (count + 1) * replacementString.length());
        result.append(replacementString);
        for (int i = 0; i < count; ++i) {
            result.append(value[i]);
            result.append(replacementString);
        }
        return new String(result);      // StringBuilder.toString() does not give exact length
    }

    final StringBuilder result = new StringBuilder(count);
    int searchStart = 0;
    do {
        // Copy characters before the match...
        result.append(value, searchStart, matchStart - searchStart);
        // Insert the replacement...
        result.append(replacementString);
        // And skip over the match...
        searchStart = matchStart + targetString.length();
    } while ((matchStart = string.indexOf(targetString, searchStart)) != -1);
    // Copy any trailing chars...
    result.append(value, searchStart, count - searchStart);
    return new String(result);          // StringBuilder.toString() does not give exact length
}