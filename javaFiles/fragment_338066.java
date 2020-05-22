protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    FileObject fileObject = getItSomehow();
    if (fileObject != null && fileObject.getBinData() != null) {
        response.setHeader("Content-disposition", "attachment; filename=\"" + fileObject.getFilename() + "\"");
        response.setContentType(fileObject.getFiletype());
        response.setContentLength((int)fileObject.getFilesize().intValue());
        response.getOutputStream().write(fileObject.getBinData());
    } else {
        // ???
    }
}