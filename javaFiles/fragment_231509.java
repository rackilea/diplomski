@WebServlet(name = "Placeholder",urlPatterns = {"/foo"})
public class Placeholder extends HttpServlet {
    public static int numbers=5;
    public void doGet (HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {
        HttpSession session = _req.getSession();
        session.setAttribute("wee","ok");
        _res.sendRedirect("index.jsp");
        }
}