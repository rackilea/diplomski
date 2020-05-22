try {
  PreparedStatement s = con.prepareStatement("INSERT INTO person(id, emri, amount, paid) VALUES (?,?,?,?)");
  s.setInt(1,id);
  s.setString(2,emri);
  s.setInt(3,amount);
  s.setInt(4,paid);
  int count =  s.executeUpdate();
  con.commit();
} catch(Exception e){
  e.printStackTrace();
  //something bad happened rollback 
  //any uncommitted changes
  con.rollback();
} finally {
  if (con != null) {
    con.close();
  }
}