Long hageId = null;

try {
    result = insertTable1.executeUpdate();
} catch (Throwable e) {
    ...
}

ResultSet rs = null;

try {
    rs = insertTable1.getGeneratedKeys();
    if (rs.next()) {
        hageId = rs.getLong(1);
    }
 ...