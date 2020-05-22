private static String removeDuplicates(String checkString, String message) {
    int idx = message.indexOf(checkString); // Find first occurrence of checkString
    if (idx == -1)
        return message; // No occurrence of checkString found
    idx += checkString.length(); // Skip first occurrence of checkString
    StringBuilder buf = new StringBuilder(message);
    while ((idx = buf.indexOf(checkString, idx)) != -1)
        buf.delete(idx, idx + checkString.length());
    return buf.toString();
}