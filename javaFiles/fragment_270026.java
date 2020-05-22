String query = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
PreparedStatement ps = conn.prepareStatement(query);
ps.setInt(e.getEmployeeId(), 1);
ps.setString(e.getFirstName(), 2);
ps.setDate(e.getHireDate(), 6);
// etc - there is a setter for each basic datatype
ps.execute();
ps.close();