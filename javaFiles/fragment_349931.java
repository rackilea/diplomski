public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private final String userID = "Pankaj";
private final String password = "journaldev";

protected void doPost(HttpServletRequest request,
        HttpServletResponse response) {
  HttpSession session=request.getSession();
  // access any value
  User user = (User)session.getAttribute("loggedInUser");
}