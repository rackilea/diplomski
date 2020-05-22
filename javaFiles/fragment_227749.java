Object around(HttpServletRequest request, HttpServletResponse response): getRequest(request, response) {
    MyHttpServletResponseWrapper wrapper = new MyHttpServletResponseWrapper(response);
    Object ret = proceed(request, wrapper);
    // The MyHttpServletReponseWrapper class captures everything and doesn't forward to the original stream, so we have to do this
    response.getWriter().write(wrapper.toString());
    // use wrapper.toString() to access response
}