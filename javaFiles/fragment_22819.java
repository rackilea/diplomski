final int length = myString.length();
for (int offset = 0; offset < length; ) {
    final int codepoint = Character.codePointAt(myString, offset);

    // use codepoint here

    offset += Character.charCount(codepoint);
}