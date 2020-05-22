@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
        Exception {
        Object asyncRequestData = request.getAttribute(LOGGER_FILTER_ATTRIBUTE);
        if (asyncRequestData == null) {
            request.setAttribute(LOGGER_FILTER_ATTRIBUTE, new AsyncRequestData(request));
        }
        return true;
    }

    @Override
    public void afterCompletion(
        HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex
    ) throws Exception {
        Object asyncRequestData = request.getAttribute(LOGGER_FILTER_ATTRIBUTE);
        if (asyncRequestData != null && response instanceof ContentCachingResponseWrapper) {
            log(request, (ContentCachingResponseWrapper) response, (AsyncRequestData) asyncRequestData);
        }
    }