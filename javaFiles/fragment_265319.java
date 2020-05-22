static String message(Throwable e) {
    StringBuilder sb = new StringBuilder();
    sb.append(e.getMessage());
    Throwable t = e.getCause();
    while (t != null) {
        sb.append("\nCaused by: ").append(t.getMessage());
        t = t.getCause();
    }
    return sb.toString();
}