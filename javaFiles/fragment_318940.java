public class MyServlet extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
       throws IOException {
       final String contentType = "text/plain;charset=UTF-8";
       final String characterEncoding = "UTF-8";

       response.setContentType(contentType);
       response.setCharacterEncoding(characterEncoding);

       PrintWriter writer = response.getWriter();

       writer.println(response.getContentType());
       writer.println(response.getCharacterEncoding());
       writer.println("السلام عليكم:");
  }
}