@WebServlet(urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAO();

        try {
            User user = userDAO.find(username, password);

            if (user != null) {
                request.getSession().setAttribute("user", user); // Login.
                response.sendRedirect("userhome");
            } else {
                request.setAttribute("message", "Unknown login, try again"); // Set error message.
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); // Redisplay form with error.
            }
        } catch (SQLException e) {
            throw new ServletException("Fatal database failure", e); // <-- Here
        }
    }

}