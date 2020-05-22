public static void main(String[] args) throws Exception {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    String strConnectionURL = "jdbc:derby:c:\data\tomcat7\active\LearnyErnie\data\derby;create=false";
    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    Connection connection = DriverManager.getConnection(strConnectionURL);
    String strCommand = "values syscs_util.syscs_get_database_property( 'DataDictionaryVersion' );";
    InputStream inputStream = new ByteArrayInputStream(strCommand.getBytes("UTF-8"));
    ij.runScript(connection, inputStream, "UTF-8", outputStream, "UTF-8");
    String strOutput = new String(outputStream.toByteArray());
    System.out.println("Output = " + strOutput);
}