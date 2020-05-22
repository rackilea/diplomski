protected final void preventCaching(HttpServletResponse response) {
    response.setHeader(HEADER_PRAGMA, "no-cache");
    if (this.useExpiresHeader) {
        // HTTP 1.0 header
        response.setDateHeader(HEADER_EXPIRES, 1L);
    }
    if (this.useCacheControlHeader) {
        // HTTP 1.1 header: "no-cache" is the standard value,
        // "no-store" is necessary to prevent caching on FireFox.
        response.setHeader(HEADER_CACHE_CONTROL, "no-cache");
        if (this.useCacheControlNoStore) {
            response.addHeader(HEADER_CACHE_CONTROL, "no-store");
        }
    }
}