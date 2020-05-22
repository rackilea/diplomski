public String replace(CharSequence target, CharSequence replacement) {
    if (target == null) {
        throw new NullPointerException("target == null");
    }
    if (replacement == null) {
        throw new NullPointerException("replacement == null");
    }

    String targetString = target.toString();
    int matchStart = indexOf(targetString, 0);
    if (matchStart == -1) {
        // If there's nothing to replace, return the original string untouched.
        return this;
    }

    String replacementString = replacement.toString();

    // The empty target matches at the start and end and between each character.
    int targetLength = targetString.length();
    if (targetLength == 0) {
        int resultLength = (count + 2) * replacementString.length();
        StringBuilder result = new StringBuilder(resultLength);
        result.append(replacementString);
//        for (int i = offset; i < count; ++i) {             // original, bug
        for (int i = offset; i < (count + offset); ++i) {    // fix
            result.append(value[i]);
            result.append(replacementString);
        }
        return result.toString();
    }

    StringBuilder result = new StringBuilder(count);
    int searchStart = 0;
    do {
        // Copy characters before the match...
        result.append(value, offset + searchStart, matchStart - searchStart);
        // Insert the replacement...
        result.append(replacementString);
        // And skip over the match...
        searchStart = matchStart + targetLength;
    } while ((matchStart = indexOf(targetString, searchStart)) != -1);
    // Copy any trailing chars...
    result.append(value, offset + searchStart, count - searchStart);
    return result.toString();
}