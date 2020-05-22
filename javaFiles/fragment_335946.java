public void saveNewAccount(String name, String username, byte[] pas, byte [] salt) {
    try (Connection c = DriverManager.getConnection("")) {
        c.setAutoCommit(false);
        String sql = "INSERT INTO accounts (NAME, USERNAME, PASSWORD, PASSWORDSALT)" +
                    " VALUES (?,?,?,?)";
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, username);
            stmt.setBytes (3, pas);
            stmt.setBytes (4, salt);
            stmt.executeUpdate();
            c.commit();
        } catch (Exception e) {
            c.rollback();
            throw e;
        }
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
}