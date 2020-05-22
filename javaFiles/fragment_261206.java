import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.*;

public class SQLServerConnection {

    private static final String LINE_SEP = System.lineSeparator();

    public static void main(String[] args) throws IOException {
        SQLConnection cnn = new SQLConnection();
        try (Connection conn = DriverManager.getConnection(cnn.dbURL, cnn.user, cnn.pass);
             PreparedStatement preStatement = conn.prepareStatement(cnn.Query);
             ResultSet result = preStatement.executeQuery();
             Writer fw = new BufferedWriter(new FileWriter(cnn.fileName))) {
            ResultSetMetaData rmsd = result.getMetaData();
            int columnCount = rmsd.getColumnCount();
            //Get the column name and print the column name
            for (int iterator = 1; iterator <= columnCount; iterator++) {
                fw.append(rmsd.getColumnName(iterator)).append(",");
            }
            fw.append(LINE_SEP);
            while (result.next()) {
                try {
                    for (int jterator = 1; jterator <= columnCount; jterator++) {
                        fw.append(result.getString(jterator)).append(',');
                    }
                    fw.append(LINE_SEP);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}