public void removeItem(int itemId) throws SQLException {
    PreparedStatement stmt = null;

    try {
        stmt = connection.prepareStatement("DELETE FROM Items where item_id = ?");
        stmt.setInt(1, itemId);
        stmt.execute();
    } catch (Exception e){
        e.printStackTrace();
    } finally {
        if(stmt != null){
            stmt.close();
        }
    }

}