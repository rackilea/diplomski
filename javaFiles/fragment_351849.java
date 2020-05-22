@WebServlet(name="MyServlet", urlPatterns = {"/MyServlet"},
    initParams = {
        @WebInitParam(name = "FILE_UPLOAD_PATH", value = "/opt/myuser/files/upload")
    })
public class MyServlet extends HttpServlet {
    private String fileUploadPath;
    public void init(ServletConfig config) {
        fileUploadPath = config.getInitParameter("FILE_UPLOAD_PATH");
    }
    //use fileUploadPath accordingly

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException) {
        String fileName = ...; //retrieve it as you're doing it now
        //using File(String parent, String name) constructor
        //leave the JDK resolve the paths for you
        File uploadedFile = new File(fileUploadPath, fileName);
        //complete your work here...
    }
}