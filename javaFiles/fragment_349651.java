Neo4jConnection conn;
ResultSet rs;     

public static void main(String[] args) {
try{
    final Driver driver = new Driver();   //org.neo4j.jdbc.Driver           
    final Properties props = new Properties();
    props.put("user", "your username");
    props.put("password", "your password");   
    String url="jdbc:neo4j://localhost:7474";
    conn = driver.connect(url, props); 

    Statement stmt = conn.createStatement()
    rs = stmt.executeQuery("MATCH (n:User) RETURN n.name");
        while(rs.next()) {
        System.out.println(rs.getString("n.name"));
        }                       
        }
   catch (SQLException e) {
    throw new RuntimeException(e);
    }
}