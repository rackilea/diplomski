...
public CharSequence subSequence(int start, int end) {
    return substring(start, end);
}

public String substring(int start, int end) {
    ...
    return new String(value, start, end - start);
}