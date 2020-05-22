@Override
protected ModelAndView doResolveException(HttpServletRequest request,
        HttpServletResponse response, Object handler, Exception ex) {

    try {
        if (ex instanceof MyNewException1) {
            return handleMyNewException1((MyNewException1) ex, request, response,
                    handler);
        }
        else if (ex instanceof MyNewException2) {
            return handleMyNewException2((MyNewException2) ex, request,
                    response, handler);
        }
    } catch (IOException handlerException) {
        logger.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception", handlerException);
        return null;
    } 

    return super.doResolveException(request, response, handler, ex);
} 

protected ModelAndView handleMyNewException1(MyNewException1 ex,
        HttpServletRequest request, HttpServletResponse response,
        Object handler) throws IOException {
            //For example send a bad request code error
    response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    return new ModelAndView();
}