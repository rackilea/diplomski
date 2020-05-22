String sql = "UPDATE mytable " +
             "SET " +
             "col1 = CASE(? WHEN 1 THEN ? ELSE col1 END), " +
             "col2 = CASE(? WHEN 1 THEN ? ELSE col2 END) " +
             "WHERE id = ?";

PreparedStatement ps = con.prepareStatement(sql);

// col1 should be updated
ps.setInt(1, 1);
ps.setString(2, newValueCol1);

// col2 should not be updated
ps.setInt(3, 0);
ps.setString(4, null); // or any other value...

// bind the where clause
ps.setInt(5, someId);

ps.executeUpdate();

// close resources and clean up, omitted for brevity's sake