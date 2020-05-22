@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    resp.setContentType("application/octet-stream");
    resp.setHeader("Content-Disposition", "filename=\"pdf.pdf\"");
    File srcFile = new File("C:/path_to_pdf/pdf.pdf");
    FileUtils.copyFile(srcFile, resp.getOutputStream());
}