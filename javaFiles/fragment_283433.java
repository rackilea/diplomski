public class FlexiServlet extends HttpServlet {
    private FileItem fileItem;

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("This ervlet requires POST but received GET");
        out.close();
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        boolean success = getParameters(request, out);
        out.write(" XXXXXXXXXXXXXXXXX" + success);
        out.write(" XXXXXXXXXXXXXXXXX" + fileItem);
        out.write("\n");
        for (String name : request.getParameterMap().keySet()) {
            out.write("PARAMETER :" + name);
            out.write("\n");
        }

        for (Part name : request.getParts()) {
            out.write("MULTIPART PARAMETER :" + name.getName());
            out.write("\n");
        }

        String p1 = request.getParameter("input1");
        out.write("RECEIVED PARAMETER:" + p1);
        out.write("\n");

        out.close();
    }

    public boolean getParameters(HttpServletRequest request, PrintWriter out) {
        List fileItemsList = null;
        try {
            if (ServletFileUpload.isMultipartContent(request)) {
                ServletFileUpload servletFileUpload = new ServletFileUpload(
                        new DiskFileItemFactory());
                try {
                    fileItemsList = servletFileUpload.parseRequest(request);
                } catch (FileUploadException ex) {
                }
                String optionalFileName = "";
                Iterator it = fileItemsList.iterator();
                while (it.hasNext()) {
                    FileItem fileItemTemp = (FileItem) it.next();
                    if (fileItemTemp.isFormField()) {
                        // for other form fields that are not multipart
                        // if (fileItemTemp.getFieldName().equals("commonName"))
                        // {
                        // commonName = fileItemTemp.getString();
                        // }
                        out.write("AAAAAAAAAAAA " + fileItemTemp.getFieldName());
                    } else {
                        if (fileItemTemp.getFieldName().equals("media_file")) {
                            fileItem = fileItemTemp;
                        }
                        out.write("BBBBBBBBBBBBBB " + fileItemTemp.getFieldName());

                    }
                }
            }
        } catch (Exception e) {
        }
        return true;
    }
}