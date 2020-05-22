public void handle(HttpServletResponse res, Connection connection, String path)throws Exception{
ServletOutputStream out = null;
try {
    byte[] bytes = "hello world".getBytes();
    res.setContentType("text/html");
    res.setContentLength(bytes.length);
    out = res.getOutputStream();
    out.write(bytes, 0, bytes.length);
} catch (Exception e) {
    e.printStackTrace();
} finally {
    out.flush();
    out.close();
}