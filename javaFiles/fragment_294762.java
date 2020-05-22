private final Random r = new Random();
public String getUniqueId() {
    try {
        while (true) {
            int n = r.nextInt(1000 * 1000) + 1000 * 1000;
            String id = ("" + n).substring(1); // number between 000000 and 999999
            if (DatabaseConnection.checkID(id))
                return id;
        }
    } catch (SQLException ex) {
        throw new IllegalStateException("Cannot access database", ex);
    }
}