public class ImageServlet extends HttpServlet {
    private final String repository = "/var/images/";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String filename = request.getParameter("file");

        // Security: '..' in the filename will let sneaky users access files
        // not in your repository.
        filename = filename.replace("..", "");

        File file = new File(repository + filename);
        if (!file.exists())
            throw new FileNotFoundException(file.getAbsolutePath());

        response.setHeader("Content-Type", "image/jpeg");
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-disposition", "attachment;filename=\"" + filename + "\"");

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        byte[] buf = new byte[1024];
        while (true) {
            int length = bis.read(buf);
            if (length == -1)
                break;

            bos.write(buf, 0, length);
        }
        bos.flush();
        bos.close();
        bis.close();
    }
}