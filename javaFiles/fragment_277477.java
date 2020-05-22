char closingOf(char c) {
    String opens = "(<[{";
    if (opens.indexOf(c) > -1) {
        // For "why" this works, see an ASCII character table. YMMV when
        // including other Unicode symbols.
        return c + (c < '<' ? 1 : 2);
    } else {
        return 0; // you get nothing
    }
}