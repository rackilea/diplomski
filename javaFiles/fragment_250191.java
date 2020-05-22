String swapParens(String s) {
    StringBuilder sb = new StringBuilder();
    sb.ensureCapacity(s.length()); // preallocate to prevent resizing
    for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        switch(c) {
            case ')': sb.append('('); break;
            case '(': sb.append(')'); break;
            default: sb.append(c);
        }
    }
    return sb.toString();

}