private String getRemoteAddress() {
    RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
    if (attribs instanceof NativeWebRequest) {
        HttpServletRequest request = (HttpServletRequest) ((NativeWebRequest) attribs).getNativeRequest();
        return request.getRemoteAddr();
    }
    return null;
}