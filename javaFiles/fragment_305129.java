String alterQuery = "alter table n0x3c_twoquestions_table add column question106 varchar(2048) NULL";
try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(alterQuery)) {
    ps.execute();
} catch (SQLException e) {
    if (e.getErrorCode() == 1060) {
        columnExists = true;
    } else {
        // TODO handle exception
    }
}