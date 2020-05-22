public class RecordController {
  private static String driverName = "org.apache.hive.jdbc.HiveDriver";

  public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
    Class.forName(driverName);
    System.setProperty("javax.security.auth.useSubjectCredsOnly","false");
    System.setProperty("java.security.krb5.conf","krb5.conf");

    Connection con = DriverManager
                         .getConnection("jdbc:hive2://host:port/arstel;" +
                                          "principal=hive/host@DOMAIN;" +
                                          "auth=kerberos;" +
                                          "kerberosAuthType=fromSubject");