public String substring(int start, int end) {
    checkRangeSIOOBE(start, end, count);
    if (isLatin1()) {
        return StringLatin1.newString(value, start, end - start);
    }
    return StringUTF16.newString(value, start, end - start);
}