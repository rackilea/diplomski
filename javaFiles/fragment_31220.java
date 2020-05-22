if (rs != null) {
    try {
        rs.close();
    } catch (Exception exception) {
        logger.log("Failed to close ResultSet", exception);
    }
}
if (st != null) {
    try {
        st.close();
    } catch (Exception exception) {
        logger.log("Failed to close Statement", exception);
    }
}
if (con != null) {
    try {
        con.close();
    } catch (Exception exception) {
        logger.log("Failed to close Connection", exception);
    }
}