class AddExpiresHeader extends HttpServletResponseWrapper {
    private static final long ONE_WEEK_IN_MILLIS = 604800000L;

    public AddExpiresHeader(HttpServletResponse response) {
        super(response);
    }

    public void setContentType(String type) {
        if (type.startsWith("text") || type.startsWith("image")) {
            super.setDateHeader("Expires", System.currentTimeMillis() + ONE_WEEK_IN_MILLIS);
        }
        super.setContentType(type);
    }
}