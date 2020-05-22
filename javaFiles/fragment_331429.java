final String DB_URL = "jdbc:derby://localhost:1527/Customers";    
Connection conn = null;
try {
     conn = DriverManager.getConnection(DB_URL);
} catch(Exception e) {
  System.out.println("Exception "+e);
}