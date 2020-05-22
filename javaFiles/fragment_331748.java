CREATE TABLE generatorsB (
  value bigint UNSIGNED NOT NULL auto_increment,
  name varchar(255) NOT NULL,
  PRIMARY KEY(value)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_swedish_ci;

// name=any comment such as an entityClass name, no real application use
public static long getGeneratorBValue(String name) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        String sql = String.format("Insert Into generatorsB (name) Values('%s')", name);
        conn = createConnection(false); // autocommit=false
        stmt = conn.createStatement();
        int rowCount = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        if (rowCount>0) {
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                long newValue = rs.getLong(1);
                if (newValue % 5 == 0) {
                    // delete old rows every 5th call, we don't need generator table rows
                    sql = "Delete From generatorsB Where value < "+ (newValue-5);
                    stmt.close();
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql, Statement.NO_GENERATED_KEYS);
                }
                conn.commit();
                return newValue;
            }
        }
        throw new IllegalArgumentException("Obtaining a generator value failed");
    } catch(Exception ex) {
        try { conn.rollback(); } catch(Exception e){}
        if (ex instanceof IllegalArgumentException) throw (IllegalArgumentException)ex;
        else throw new IllegalArgumentException(ex.getMessage(), ex);
    } finally {
        if (conn!=null) close(rs, stmt, conn);
    }
}