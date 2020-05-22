String rowToUpdate = "foo";
PreparedStatement ps = myConnection.prepareStatement(
      "UPDATE my_table SET date_field=? WHERE id=?");
Calendar cal = Calendar.getInstance();
java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
ps.setDate(1, sqlDate);
ps.setString(2, rowToUpdate);
int updated = ps.executeUpdate();