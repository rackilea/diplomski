@Override
protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
        throws ServletException, IOException {

    httpServletResponse.setContentType("text/html");
    PrintWriter printWriter = httpServletResponse.getWriter();

    InputStream inputStream;
    FileOutputStream fileOutputStream;

    for (Part part : httpServletRequest.getParts()) {

        inputStream = httpServletRequest.getPart(part.getName()).getInputStream();
        int i = inputStream.available();
        byte[] b = new byte[i];
        inputStream.read(b);
        String fileName = "";

        for (String temp : part.getHeader("content-disposition").split(";")) {
            if (temp.trim().startsWith("filename")) {
                fileName = temp.substring(temp.indexOf('=') + 1).trim().replace("\"", "");
            }
        }

        String uploadDir = "/temp";
        fileOutputStream = new FileOutputStream(uploadDir + "/" + fileName);
        fileOutputStream.write(b);
        inputStream.close();
        fileOutputStream.close();

        printWriter.write("Uploaded file " + uploadDir + "/" + fileName + ".");
    }
}