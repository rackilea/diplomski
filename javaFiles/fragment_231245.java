try (
    Connection con = DriverManager.getConnection("Stuff");
    Statement stmt = con.createStatement();
){
    while(someBoolean){          
        try (ResultSet rs = stmt.executeQuery("SQL query")) {
            // do stuff with query results.
        }
    } //end while
} catch (Exception e){
    //handle exception
}