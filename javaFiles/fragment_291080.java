String makeZs(String in) {
    StringBuilder b = new StringBuilder();
    for(int i = 0; i < in.length(); ++i) {
        b.append("z");
    }
    return b.toString();
}