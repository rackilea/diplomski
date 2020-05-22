String getRemoteIP(HttpServletRequest request) {
    String xff = request.getHeader("X-Forwarded-For");
    if (xff != null) {
        return xff.split("[\\s,]+")[0];
    }
    return request.getRemoteAddr();
}