public class PersonDao {
    private DataSource ds; //add a setter and inject the JDBC resource
    public List<Person> getPersons() {
        List<Person> personList = new ArrayList();
        Connection con;
        PreparedStatement pstmt;
        try {
            con = ds.getConnection(username, password);
            pstmt = con.prepareStatement("SELECT * FROM PERSON");
            ResultSet rs = pstmt.executeQuery(query); 
            //Fetch the resultset, iterate over it and populate the list
            while (rs.next()) {
                Person p = new Person();
                p.setName(rs.getString("name");
                personList.add(p);
            }
        } catch (Exception ex {
            // ... code to handle exceptions
       } finally {
            if (con != null) con.close();
       }

      return personList;
}