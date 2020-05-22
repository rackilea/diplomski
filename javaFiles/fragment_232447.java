myConnect = getConnection();
  myConnect.setAutoCommit(false);
  File file = new File(fileName);
  fis = new FileInputStream(file);
  pstmt = myConnect.prepareStatement("insert into customer( " + SSN + ", " + CNAME + "," +
         GENDER + ", " + AGE + ", " + PROFESSION +") values (?,?,?,?,?)");
  pstmt.setString(1, SSN);
  pstmt.setString(2, AGE);
   ....
  pstmt.executeUpdate();
  myConnect.commit();