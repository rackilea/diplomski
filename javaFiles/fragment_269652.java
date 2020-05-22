public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

      // Getting ServletContext from request
      ServletContext ctx= req.getServletContext();
      // Get the absolute path of the file
      String filename = ctx.getRealPath("resources/file.text");
      // getting mimeType of the file
      String mime = ctx.getMimeType(filename);
      // Error handling
      if (mime == null) {
        res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return;
      }

      // Setting MIME content type
      res.setContentType(mime);
      // Getting file object
      File file = new File(filename);
      // Setting content length header
      res.setContentLength((int)file.length());

       // FileInputStream to read from file
      FileInputStream in = new FileInputStream(file);
      // Obtain OutputStream from response object
      OutputStream out = res.getOutputStream();

      // Writing to the OutputStream
       byte[] buffer = new byte[1024];
       int bytes = 0;
       //  we stop when in.read returns -1 and read untill it does not
       while ((bytes = in.read(buffer)) >= 0) {
         out.write(buffer, 0, count);
      }
    // Clean up, closing resources
    out.close();
    in.close();

}