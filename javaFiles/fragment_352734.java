import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




/**
 * Servlet implementation class SearchServlet
 */
@SuppressWarnings("deprecation")
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;



    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings({ "unchecked" })
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Tbphonebook.class)
                .buildSessionFactory();
        Session session = factory.getSessionFactory().openSession();
        session.beginTransaction();

        String firstName = request.getParameter("searchFirstName");


        @SuppressWarnings("rawtypes")
        Query query = session.createQuery("from Tbphonebook where firstname = ?");

        query.setParameter(0, firstName);


        List<Tbphonebook> persons = (List<Tbphonebook>) query.getResultList();

        request.setAttribute("persons", persons);

        request.getRequestDispatcher("index.jsp").forward(request, response);

        response.sendRedirect("index.jsp");


        session.getTransaction().commit();
        session.close();        
    }
}