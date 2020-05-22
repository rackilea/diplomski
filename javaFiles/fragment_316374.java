@members {
public boolean isValue() {
    int offset = _tokenStartCharIndex;
    for (int idx = offset-1; idx >=0; idx--) {
        String s = _input.getText(Interval.of(idx, idx));
        if (Character.isWhitespace(s.charAt(0))) {
            continue;
        } else if (s.charAt(0) == '=') {
            return true;
        } else {
            break;
        }
    }
    return false;
}
}