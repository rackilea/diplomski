public String getUniqueId() {
    try {
        String maxId = DatabaseConnection.selectMaxId();
        int n = Integer.parseInt(maxId) + 1;
        return ("" + n).substring(1); // number between 000000 and 999999
    } catch (SQLException ex) {
        throw new IllegalStateException("Cannot access database", ex);
    }
}