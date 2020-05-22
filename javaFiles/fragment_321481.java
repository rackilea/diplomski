private String listToString(List<?> l) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < l.size(); i++) {
        sb.append(l.get(i));
        if (i != l.size() -1) sb.append(", ");
    }
    return sb.toString();
}