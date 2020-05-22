int strIndex;
char[] chars = new char[2];

for (int arrayIndex = 0; arrayIndex < arrayLen; arrayIndex++) {
    strIndex = 2 * arrayIndex;
    chars[0] = input.charAt(strIndex);
    chars[1] = input.charAt(strIndex + 1);
    result[arrayIndex] = Byte.parseByte(new String(chars), 16);
}

// Done
return result;