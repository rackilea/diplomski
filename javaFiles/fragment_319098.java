public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    if (!(req instanceof MultipartHttpServletRequest)) {
        error(resp, "Invalid request (multipart request expected)");
        return null;
    }
Map<String, MultipartFile> files = ((MultipartHttpServletRequest)req).getFileMap();
... do thomething with the files