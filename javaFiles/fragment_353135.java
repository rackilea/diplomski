@Override
ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    if (ex instanceof MultipartException){
        response.sendError(413,"Content is to big. Maximal allowed request size is: ${Application.MAX_REQUEST_SIZE}")
    }
}