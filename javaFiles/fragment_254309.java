@Inject
    private HttpServletRequest request;
    ...
    // get root folder of webapp
    String root = request.getRealPath("/");
    // get abs path from any relative path
    String abs = root + '/' + relPath;