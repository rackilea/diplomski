package LogIn;


import dbUtil.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogInModel {

    private static final String sql = "SELECT * FROM MessyLogin where username = ? and Password = ?";

    private Connection connection;

    public LogInModel(Connection connection) {
        this.connection = connection;
    }

    public boolean isLogin(String username, String password) {
        boolean isValidUser = false;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, username);
            pr.setString(2, password);    
            rs = pr.executeQuery();
            while (rs.hasNext()) {
                isValidUser = true; 
            }
        } catch (SQLException ex) {  
            e.printStackTrace();      
            isValidUser = false;
        } finally {
              dbUtils.close(rs);
              dbUtils.close(pr);
        }
        return isValidUser;
    }      
}