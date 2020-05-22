public Response addCLocation(String eId) throws SQLException {

    String dataSourceName = "DBname";
    String dbURL = "jdbc:mysql://localhost:3306/" + dataSourceName;
    String result = "";
    Connection con = null;
    Statement s = null;
    PreparedStatement ps = null;
    ResultSet rs = null, rs1 = null;
    String id = eId;

    try {
      try {
        // Database Connector Driver
        Class.forName("com.mysql.jdbc.Driver");
        // Connection variables: dbPath, userName, password
        con = DriverManager.getConnection(dbURL, "someusername", "somepassword");
        System.out.println("We are connected to database");
        s = con.createStatement();
        // SQL Statement to Execute
        System.out.print(id);
        PreparedStatement alreadyThere = con.prepareStatement("SELECT 1 FROM CList WHERE Number = ?");
        alreadyThere.setString(1, eId);
        System.out.println("0");
        // Parse SQL Response
        int i = 0;
        if (rs.next() == false) {
          SMember sm = new SMember();
          ps = con
              .prepareStatement("INSERT INTO Contact_List (Number, First_Name, Last_Name, Phone_Number) VALUES (?,?,?,?)");
          ps.setString(1, sm.getEmployeeID());
          ps.setString(2, sm.getFirstName());
          ps.setString(3, sm.getLastName());
          ps.setString(4, sm.getPhone());
          ps.executeUpdate();
        }
        else {
          result = "[Contact is already on the list]";
        }
      }
      catch (Exception e) {
        System.out.println("Can not connect to database");
        e.printStackTrace();
      }
      finally {
        // Close Database Connection
        s.close();
        ps.close();
        con.close();
      }
    }
    catch (Exception e) {
      System.out.println(e);
    }
    // Return the Result to Browser
    return Response.status(200).entity(result).build();
  }