public class ImageServlet extends HttpServlet {
...
     protected void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
     String imageName = request.getParameter("imageId");
     //Read image into byte array
     byte[] data = ImageHolder.readImage(imageName);
     //Write image into output stream
     response.setContentType("image/jpeg");
     response.getOutputStream().write(data);
     }

}