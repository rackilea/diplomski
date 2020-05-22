import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class GreekTestMain {

    public static void main(String[] args) {
        String connUrl = 
                "jdbc:mysql://192.168.1.3/greektest?" +
                "useUnicode=yes&characterEncoding=UTF-8" +
                "&user=root&password=obfuscated";
        try (Connection conn = DriverManager.getConnection(connUrl)) {
            String sql = "INSERT INTO `chars` (`value`) VALUES (?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "ασδασδ");
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

}