String sql = "select Latitude from View_4 where IMEI='xxxxx'";
Statement std = null;
ResultSet rs = null;
logger.info("executeQuery - sql=" + sql);
try {
    std = connection.createStatement();
    rs = std.executeQuery(sql);
    logger.info("executeQuery - The query is executed");
    while (rs.next()) {
        String lat = rs.getString("Latitude");
        logger.info("executeQuery - Latitude=" + lat);
    }
    logger.info("executeQuery - Query End");
} catch (SQLException e) {
    logger.error("executeQuery", e); //log the full error
} finally {
    if (rs != null) {
        try {rs.close();} catch (SQLException sqle) {}
    }
    if (std != null) {
        try {std.close();} catch (SQLException sqle) {}
    }
}