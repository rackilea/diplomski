public String nextPlaceholderFinder() throws IOException {
    for (int p = reader.read(); p != -1; p = reader.read()) {
        if (p == '$') {
            if (state == NORMALTEXT) {
                state = PLACEHOLDERTEXT; 
                placeholder.append((char) p);
            } 
        } else if (state == PLACEHOLDERTEXT) {
            placeholder.append((char) p);
        }
        if (p == '}') {
            if (state == PLACEHOLDERTEXT) {
                state = NORMALTEXT;
            }
        }
    }
    return placeholder.toString();
}