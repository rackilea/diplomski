static String stripHtmlTags(String html) {
    StringBuilder sb = new StringBuilder(html);
    int open;
    while ((open = sb.indexOf("<")) != -1) {
        int close = sb.indexOf(">", open + 1);
        sb.delete(open, close + 1);
    }
    return sb.toString();
}