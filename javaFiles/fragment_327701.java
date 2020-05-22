public class DownloadServlet extends HttpServlet {

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=data.zip");

        // You might also wanna disable caching the response
        // here by setting other headers...

        try ( ZipOutputStream zos = new ZipOutputStream(response.getOutputStream()) ) {
            // Add zip entries you want to include in the zip file
        }
    }
}