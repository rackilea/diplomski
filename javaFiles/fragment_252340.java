private String getValue(StringTokenizer st, String name) {
    if (st.hasMoreTokens()) {
        return st.nextToken().trim();
    }
    else {
        throw new RuntimeException("Missing value for " + name);
    }
}