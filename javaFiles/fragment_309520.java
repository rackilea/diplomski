public class Employee 
{
....
private byte[] fileBytes;
.....
}

@MultipartConfig(maxFileSize = 18177215)   
 @WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUploadServlet"})
public class FileUploadServlet extends HttpServlet
  {

 protected void processRequest(HttpServletRequest request, 
    HttpServletResponse response)
        throws ServletException, IOException {
    ....
    InputStream is = filePart.getInputStream()
    emp1.setFileBytes(IOUtils.toByteArray(is))
    }
......
}

public Employee addImage(Employee emp1) {
  Connection con = null;
  Statement stmt = null;
  ....
   pstmt.setBytes(5,emp1.getFileBytes());
  ....
}