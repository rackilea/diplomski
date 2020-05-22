private String getParentId(String id) {
    int lastDot = id.lastIndexOf(".");
    if (lastDot == -1) {
        return null;
    }
    return id.substring(0, lastDot);
}