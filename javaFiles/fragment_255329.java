public String(String toCopy) {
    value = (toCopy.value.length == toCopy.count)
        ? toCopy.value
        : Arrays.copyOfRange(toCopy.value, toCopy.offset,
            toCopy.offset + toCopy.length());
    offset = 0;
    count = value.length;
}