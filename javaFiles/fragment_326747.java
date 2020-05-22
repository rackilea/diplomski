package sarah;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class dbconnector {

    //String user = "system";
    //String pass = "system";
    //String driver = "oracle.jdbc.OracleDriver";
    //String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
    ResultSet rs;
    Connection connection = null;
    Statement stmt = null;

    public Connection Open() {

        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "root");
            System.out.println("Succeed!");
            // return connection;

        } catch (Exception e) {

            System.out.println("you have stucked with error!!!!!!");

        }

        System.out.println("MySQL JDBC Driver Registered!");

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        return connection;
    }

    public void db_Close(Connection con) throws SQLException {
        con.close();
        return;
    }
}

class employee {

    String eid;
    String ename;
    String esalary;

    // public employee(String eid, String ename, String esalary) {
    //  this.eid = eid;
    // this.ename = ename;
    // this.esalary = esalary;
    //}


    public String getId() {
        return eid;
    }

    public void setId(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return ename;
    }

    public void setName(String ename) {
        this.ename = ename;
    }

    public String getSalary() {
        return esalary;
    }

    public void setSalary(String esalary) {
        this.esalary = esalary;
    }

}

class insertclass {

    // Connection connection = null;
    PreparedStatement ps;
    public String query;

    public boolean insertfunction(employee ob) throws ClassNotFoundException, SQLException {
        try {
            dbconnector dbc = new dbconnector();
            Connection connection = dbc.Open();
            query = "insert into employee (eid,ename,esalary) values(?,?,?)";
            java.sql.PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ob.getId());
            ps.setString(2, ob.getName());
            ps.setString(3, ob.getSalary());

            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }
}

@WebServlet(name = "Test", urlPatterns = {"/Test"})
public class Test extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            employee obj = new employee();
            obj.setId(request.getParameter("eid"));
            obj.setName(request.getParameter("ename"));
            obj.setSalary(request.getParameter("esalary"));

            try {
                new insertclass().insertfunction(obj);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.print("sucess");
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}