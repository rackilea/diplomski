/**
 * Escapes invalid XML Unicode code points in a <code>{@link String}</code>. The
 * DOM API already escapes predefined entities, such as {@code "}, {@code &},
 * {@code '}, {@code <} and {@code >} for
 * <code>{@link org.w3c.dom.Text Text}</code> nodes. Therefore, these Unicode
 * code points are ignored by this function. However, there are some other
 * invalid XML Unicode code points, such as {@code '\u0000'}, which are even
 * invalid in their escaped form, such as {@code "&#0;"}.
 * <p>
 * This function replaces all {@code '#'} by {@code "##"} and all Unicode code
 * points which are not in the ranges #x9 | #xA | #xD | [#x20-#xD7FF] |
 * [#xE000-#xFFFD] | [#x10000-#x10FFFF] by the <code>{@link String}</code>
 * {@code "#c;"}, where <code>c</code> is the Unicode code point.
 * 
 * @param string the <code>{@link String}</code> to be escaped
 * @return the escaped <code>{@link String}</code>
 * @see <code>{@link #unescapeInvalidXmlCharacters(String)}</code>
 */
public static String escapeInvalidXmlCharacters(String string) {
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0, codePoint = 0; i < string.length(); i += Character.charCount(codePoint)) {
        codePoint = string.codePointAt(i);

        if (codePoint == '#') {
            stringBuilder.append("##");
        } else if (codePoint == 0x9 || codePoint == 0xA || codePoint == 0xD || codePoint >= 0x20 && codePoint <= 0xD7FF || codePoint >= 0xE000 && codePoint <= 0xFFFD || codePoint >= 0x10000 && codePoint <= 0x10FFFF) {
            stringBuilder.appendCodePoint(codePoint);
        } else {
            stringBuilder.append("#" + codePoint + ";");
        }
    }

    return stringBuilder.toString();
}

/**
 * Unescapes invalid XML Unicode code points in a <code>{@link String}</code>.
 * Makes <code>{@link #escapeInvalidXmlCharacters(String)}</code> undone.
 * 
 * @param string the <code>{@link String}</code> to be unescaped
 * @return the unescaped <code>{@link String}</code>
 * @see <code>{@link #escapeInvalidXmlCharacters(String)}</code>
 */
public static String unescapeInvalidXmlCharacters(String string) {
    StringBuilder stringBuilder = new StringBuilder();
    boolean escaped = false;

    for (int i = 0, codePoint = 0; i < string.length(); i += Character.charCount(codePoint)) {
        codePoint = string.codePointAt(i);

        if (escaped) {
            stringBuilder.appendCodePoint(codePoint);
            escaped = false;
        } else if (codePoint == '#') {
            StringBuilder intBuilder = new StringBuilder();
            int j;

            for (j = i + 1; j < string.length(); j += Character.charCount(codePoint)) {
                codePoint = string.codePointAt(j);

                if (codePoint == ';') {
                    escaped = true;
                    break;
                }

                if (codePoint >= 48 && codePoint <= 57) {
                    intBuilder.appendCodePoint(codePoint);
                } else {
                    break;
                }
            }

            if (escaped) {
                try {
                    codePoint = Integer.parseInt(intBuilder.toString());
                    stringBuilder.appendCodePoint(codePoint);
                    escaped = false;
                    i = j;
                } catch (IllegalArgumentException e) {
                    codePoint = '#';
                    escaped = true;
                }
            } else {
                codePoint = '#';
                escaped = true;
            }
        } else {
            stringBuilder.appendCodePoint(codePoint);
        }
    }

    return stringBuilder.toString();
}