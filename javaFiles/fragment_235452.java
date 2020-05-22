private final String DB_HOST = "YOUR_EC2_HOSTNAME";
private final String DB_PORT = "5432";
private final String DB_USER = "YOUR_POSTGRES_USERNAME";
private final String DB_PASSWD = "YOUR_POSTGRES_PASSWORD";
private final String DB_NAME = "YOUR_POSTGRES_DBNAME";
private final String DB_URL = "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

private final String INSERT = "INSERT INTO articles (date, name, uuid) VALUES (?, ?, ?)";
private Connection db = null;

public PostgreSQLService() {
    try {
        Class.forName("org.postgresql.Driver");
        db = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
    } catch (ClassNotFoundException | SQLException ex) {
        log.error(ex);
    }

    try (PreparedStatement st = db.prepareStatement(INSERT)) {
        st.setEscapeProcessing(false);

        st.setDate(1, new java.sql.Date(DateUtil.getToday().getTime()));
        st.setString(2, "YOUR_NAME");
        st.setObject(3, UUID.randomUUID());

        if (st.executeUpdate() <= 0) {
            throw new PostgreSQLServiceException("0 rows inserted while trying to insert a new row ::: " + st.toString());
        }

    } catch (SQLException sqle) {
        throw new PostgreSQLServiceException("Received an SQLException trying to insert a row", sqle);
    }
}