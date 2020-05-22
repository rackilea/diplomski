// without db name
public static final String HOST = "jdbc:postgresql://localhost:5432/";

Statement stmt = conn.createStatement();
stmt.executeUpdate("CREATE DATABASE JavaDB");
stmt.executeUpdate("CREATE USER java_user WITH PASSWORD  \'java\'");
// ...