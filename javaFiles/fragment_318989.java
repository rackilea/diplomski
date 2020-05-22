import java.io.File;
import java.sql.*;
import net.ucanaccess.complex.Attachment;

...

String dbFileSpec = "C:/Users/Public/AttachmentsDB.accdb";
String connStr = "jdbc:ucanaccess://" + dbFileSpec;
try (Connection conn = DriverManager.getConnection(connStr)) {
    try (Statement s = conn.createStatement()) {
        try (ResultSet rs = s.executeQuery(
                "SELECT Attachments FROM AttachmentsTable WHERE ID=1")) {
            rs.next();
            // retrieve array of net.ucanaccess.complex.Attachment objects
            Attachment[] atts = (Attachment[]) rs.getObject(1);
            for (Attachment att : atts) {
                System.out.println(att.getName());
                org.apache.commons.io.FileUtils.writeByteArrayToFile(
                        new File("C:/Users/Gord/Desktop/" + att.getName()), 
                        att.getData());
            }
        }
    }
}