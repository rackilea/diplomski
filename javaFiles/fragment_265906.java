import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.jdbc.odbc.*;

/**
 *
 * @author 
 */
@WebServlet(urlPatterns = {"/FoodServlet"})
public class FoodServlet extends HttpServlet {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement pstmt;
    private DatabaseMetaData dbmd;

    //Servlet initialization method creates con/stmt objects and loads jdbc drivers
    public void init() throws ServletException {
        try {
            new JdbcOdbcDriver();
            String url = "jdbc:odbc:Java3DB";
            String user = "";
            String pword = "";
            con = DriverManager.getConnection(url, user, pword);
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //open html tags
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>FoodServlet</title>");
            out.println("</head>");
            out.println("<body>");

            //set up the table
            createTable();

            //set strings for queries and update statements
            String update = "UPDATE Foods SET likes = (likes + 1) WHERE itemName = ?";

            //set foodValue to request parameter from html
            String foodValue = null;
            foodValue = request.getParameter("food");
            //update only if there is a value stored in the food parameter
            if (foodValue != null) {
                //out.println(foodValue);
                pstmt = con.prepareStatement(update);
                pstmt.setString(1, foodValue);
                pstmt.executeUpdate();
            }

            //output the data from the database
            rs = stmt.executeQuery("SELECT itemID, itemName, likes FROM Foods");
            out.println("ItemID&nbsp&nbspItemName&nbsp&nbspLikes <BR>");

            while (rs.next()) {
                out.print(+rs.getInt(1) + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" 
                        + rs.getString(2) + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" 
                        + rs.getInt(3) + "<br>");
            }

            out.println("</body>");
            out.println("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.print(e.getMessage());
        }
    }

    //destroy method to close the servlet
    public void destroy() {
        try {
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FoodServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createTable() throws SQLException {
        dbmd = con.getMetaData();
        rs = dbmd.getTypeInfo();
        //checks for the Foods table, create only if not table is found
        if (rs.next() == false) {
            //set up the database
            stmt.executeUpdate("CREATE TABLE Foods (itemID INTEGER, itemName VARCHAR(20), likes Integer)");
            stmt.executeUpdate("INSERT INTO Foods VALUES (1, 'IceCream', 0)");
            stmt.executeUpdate("INSERT INTO Foods VALUES (2, 'Hamburger', 0)");
            stmt.executeUpdate("INSERT INTO Foods VALUES (3, 'Pizza', 0)");
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FoodServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FoodServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}