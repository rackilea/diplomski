import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greetings")
public class GreetingsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "Hello, World";
        req.setAttribute("message", message);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/jsp/greetings.jsp");
        dispatcher.forward(req, resp);
    }

}