@RemoteServiceRelativePath("MyServlet")
public class MyServlet extends HttpServlet {

    @Override
    protected final void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        String fileContent = "";

        try {
            List<FileItem> items = upload.parseRequest(req);
            //the items.get(0) is very error-prone, but good enough for this example 
            fileContent = IOUtils.toString(items.get(0).getInputStream(), Charset.forName("UTF-8"));

        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        String fileName = "filename.txt";

        resp.setContentType("text/plain;charset=UTF-8");
        resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        OutputStream out = resp.getOutputStream();
        out.write(fileContent.getBytes(Charset.forName("UTF-8")));
        out.flush();
        out.close();

    }

}