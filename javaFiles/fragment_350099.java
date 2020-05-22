String query = "insert into " + table + " (name, department) values (?,?)";
try(PreparedStatement ps = connection.prepareStatement(query)) {
    for(Node n : vertices) {
        ps.setString(1, n.getName());
        ps.setInt(2, n.getOrgId());
        ps.addBatch();
    }
    ps.executeBatch();
} catch(SQLException e) {
    // Exception handling
}