/**
* From xml spec valid chars:<br>
* #x9 | #xA | #xD | [#x20-#xD7FF] | [#xE000-#xFFFD] | [#x10000-#x10FFFF]<br>
* any Unicode character, excluding the surrogate blocks, FFFE, and FFFF.<br>
* @param text The String to clean
* @param replacement The string to be substituted for each match
* @return The resulting String
*/
public static String CleanInvalidXmlChars(String text, String replacement) {
    String re = "[^\u0009\r\n\u0020-\uD7FF\uE000-\uFFFD\uD800\uDC00-\uDBFF\uDFFF]";
    return text.replaceAll(re, replacement);
}