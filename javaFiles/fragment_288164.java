String sql = ...
PreparedStatement prep;
prep = conn.prepareStatement(sql);
prep.setInt(1, x);
prep.setString(2, y);
prep.setString(3, z);
prep.execute();