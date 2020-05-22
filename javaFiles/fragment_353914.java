protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    String fileName = "filepath";
    File file = new File(fileName);
    FileInputStream fis = new FileInputStream(file);
    byte[] buffer = new byte[fis.available()];
    fis.read(buffer);
    fis.close();

    resp.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,"utf-8"));
    resp.addHeader("Content-Length",String.valueOf(file.length()));
    OutputStream out = new BufferedOutputStream(resp.getOutputStream());
    resp.setContentType("application/octet-stream");
    out.write(buffer);
    out.flush();
    out.close();

}