/*
 * Internal version of the String(char[], int, int) constructor.
 * Does not range check, null check, or copy the character array.
 */
String(int offset, int charCount, char[] chars) {
    this.value = chars;
    this.offset = offset;
    this.count = charCount;
}