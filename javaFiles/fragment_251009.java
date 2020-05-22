@RequestMapping(value = "/download/attachment/", method = RequestMethod.GET)
    public void getAttachmentFromDatabase(HttpServletResponse response) {
        response.setContentType("application/octet-stream");
response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getFileName() + "\"");
                    response.setContentLength(file.length);
                    FileCopyUtils.copy(file as byte-array, response.getOutputStream());
                    response.flushBuffer();
}