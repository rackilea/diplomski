package com.pack;
import java.io.IOException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.api.datastore.Text;

public class LoginServlet extends HttpServlet {

/**
 * 
 */
private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) 
throws IOException, ServletException {

    Text content = new Text(request.getParameter("content"));

    String poster = request.getParameter("poster");


    Entry entry = new Entry(content, poster);

    PersistenceManager pm = PMF.get().getPersistenceManager();
    pm.makePersistent(entry);
    pm.close();
    response.sendRedirect("login.jsp");

}
}