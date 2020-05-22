import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class PersonalInfoOutput extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String address = request.getParameter("address");
            boolean st = false;
            try { 
                Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                Connection con =    DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_system", "root", ""); 
                PreparedStatement ps = con.prepareStatement("select FirstName, LastName, Address from payroll_system.employee_info where employeeID = 1234"); 
                ResultSet rs = ps.executeQuery(); 
                st = rs.next(); 
                if(st){

                out.println(rs.getString("FirstName"));
                out.println(rs.getString("LastName"));
                out.println(rs.getString("Address"));

                }
             }catch(Exception e)
              {
                  e.printStackTrace();
              }
            out.close();
    }
}