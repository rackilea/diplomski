protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    InputStream in = req.getInputStream();
    OutputStream out = new FileOutputStream("myfile.jpg");
    IOUtils.copy(in, out);
    out.flush();
    out.close();
}