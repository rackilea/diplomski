@WebServlet("/profile")
public class Profile extends HttpServlet {

    // Don't use member variables on Servlets - they get reused for all users!
    // private String login;
    // private HttpSession httpSession;
    // private User user;
    // private Role role;
    public static Logger LOGGER = LogManager.getLogger(Profile.class.getName());

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    HttpSession httpSession = req.getSession();
    try (PrintWriter out = resp.getWriter()) {
        if (httpSession.getAttribute("userLoggedIn") == null) {
            out.println("<title>Login Page</title>");
            out.println("<p><a href=\"index\">Please follow the link to login</a></p>");            
        } 
        else {
            User user = httpSession.getAttribute("userLoggedIn");
            Role role = httpSession.getAttribute("userRole");

            out.println("<title>Profile page</title>");
            out.println("user id = " + user.getUserId());
            out.println("login = " + user.getLogin());
            out.println("password = " + user.getPassword());
            out.println("role = " + role.getRoleName());
            out.println("<form action=\"logout\" method=\"get\"/>" +
                    "<input type=\"submit\" value=\"Logout\"/>" +
                    "</form>");
            if("true".equals(httpSession.getAttribute("isAdmin")) {
                httpSession.setAttribute("isAdmin", true);
                out.println("<a href=\"admin\">Go to admin page</a>");
            }
        }
    } catch (IOException | NullPointerException e) {
        LOGGER.error(e);
    }
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        User user = new ImplUserDAO().findByLogin(login);
        HttpSession httpSession = req.getSession();
        try (PrintWriter out = resp.getWriter()) {
            if (user != null && user.getPassword().equals(req.getParameter("pass"))) {
                Role role = new ImplRoleDAO().findById(user.getRoleId());
                httpSession.setAttribute("userLoggedIn", user);
                httpSession.setAttribute("userRole", role);
                if (role.getRoleName().equals("admin")) {
                    httpSession.setAttribute("isAdmin", true);
                }
                // Now refer to display part.
                goGet(req, resp);
            } else {
                out.println("Wrong login or password");
                out.println("<a href=\"index\">Please follow the link to login</a>");
            }
        } catch (IOException | NullPointerException e) {
            LOGGER.error(e);
        }
    }
}