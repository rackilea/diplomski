import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.professional_webworkx.database.DataBroker;
import de.professional_webworkx.model.Person;

@WebServlet(urlPatterns = {"/personServlet"})
public class PersonServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 318982491390578805L;

    private DataBroker<Person> dataBroker = new DataBroker<>();

    public PersonServlet() {
        super();
    }
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // do something with the user input from the jsp file
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }



}