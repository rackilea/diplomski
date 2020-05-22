package jsp;

import java.io.*;
//import java.util.*;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

 @WebServlet(urlPatterns = {"/LoginValidation"})
public class Validation extends HttpServlet {

private static final long serialVersionUID = 1L;
private ServletConfig config;

public void init (ServletConfig config) 
throws ServletException{
    this.config = config;
}

public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException,IOException {


    PrintWriter out = response.getWriter();
    String connectionURL = "jdbc:mysql://localhost/dblogin";
    Connection connection = null;
    ResultSet rs;
    String userid = new String("");
    String password = new String("");

    response.setContentType("text/html");
    try {
        // Load the database driver
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(connectionURL, "root", "");
        //Add the data into the database
        String sql = "SELECT userid, password FROM login";
        Statement s = connection.createStatement();
        s.executeQuery(sql);
        rs = s.getResultSet();

        while(rs.next()) {
            userid = rs.getString("userid");
            password = rs.getString("password");

                if(userid.equals(request.getParameter("userid")) && password.equals(request.getParameter("password"))) 
                {
                    out.println("The user is valid");

                    //Write exit program code or rediraction code here
                } 

        }
        rs.close();
        s.close();

    } catch(Exception e) {
        System.out.println("Exception is: " + e);
      }


 }

}