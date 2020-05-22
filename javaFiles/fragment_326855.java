public void testQuery() {
    Entity criteria = new Entity();
    criteria.setId(7777);
    try (Connection connection = yourDatabase.getConnection()) {
        List<Entity> assets = QueryTest.query(connection, criteria, "AND");
    } catch (SQLException ex) {
        Logger.getLogger(IwiPrivateTest.class.getName()).log(Level.SEVERE, null, ex);
    }
}