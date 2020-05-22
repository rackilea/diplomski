String sql = ...
PreparedStatement prep;
prep = conn.prepareStatement(sql);
for (...) {
    prep.setInt(1, x);
    prep.setString(2, y);
    prep.setString(3, z);
    prep.addBatch();
}
prep.execute();