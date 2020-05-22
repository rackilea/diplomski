public static final boolean isMultipartContent(
        HttpServletRequest request) {
    if (!"post".equals(request.getMethod().toLowerCase())) {
        return false;
    }
    String contentType = request.getContentType();
    if (contentType == null) {
        return false;
    }
    if (contentType.toLowerCase().startsWith(MULTIPART)) {
        return true;
    }
    return false;
}