/*
    If you are running on JDK 6 or higher, you do not
    need to invoke Class.forName(). In that environment, the
    EmbeddedDriver loads automatically.
*/
Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
Connection conn = DriverManager.getConnection("jdbc:derby:sample");