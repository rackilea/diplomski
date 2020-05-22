/**
 * Reads last {@code length} characters from UTF-8 encoded text file.
 * <p>
 * The returned string may be shorter than requested if file is too
 * short, if the leading character is a half surrogate-pair, or if
 * file has invalid UTF-8 byte sequences.
 * 
 * @param fileName Name of text file to read.
 * @param length Length of string to return.
 * @return String with up to {@code length} characters.
 * @throws IOException if an I/O error occurs.
 */
public static String readLastChars(String fileName, int length) throws IOException {
    // A char can only store characters in the Basic Multilingual Plane, which are
    // encoded using up to 3 bytes each. A character from a Supplemental Plane is
    // encoded using 4 bytes, and is stored in Java as a surrogate pair, ie. 2 chars.
    // Worst case (assuming valid UTF-8) is that file ends with a 4-byte sequence
    // followed by length-1 3-byte sequences, so we need to read that many bytes.
    byte[] buf;
    try (RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
        int bytesToRead = length * 3 + 1;
        buf = new byte[bytesToRead <= file.length() ? bytesToRead : (int) file.length()];
        file.seek(file.length() - buf.length);
        file.readFully(buf);
    }
    // Scan bytes backwards past 'length' characters
    int start = buf.length;
    for (int i = 0; i < length && start > 0; i++) {
        if (buf[--start] < 0) { // not ASCII
            // Locate start of UTF-8 byte sequence (at most 4 bytes)
            int minStart = (start > 3 ? start - 3 : 0);
            while (start > minStart && (buf[start] & 0xC0) == 0x80)
                start--; // Skip UTF-8 continuation byte
            if (start == minStart)
                i++; // 4-byte UTF-8 -> 2 surrogate chars
        }
    }
    // Create string from bytes, and skip first character if too long
    // (text starts with surrogate pair, assuming valid UTF-8)
    String text = new String(buf, start, buf.length - start, StandardCharsets.UTF_8);
    while (text.length() > length)
        text = text.substring(text.offsetByCodePoints(0, 1));
    return text;
}