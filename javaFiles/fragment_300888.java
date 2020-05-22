try {
    conn = LicenseDBSource.getInstance().getConnection();
    statement = conn.prepareStatement(
        "SELECT " + 
        "    (LOCALTIMESTAMP < expiration) AS user_is_current " +
        "FROM " +
        "    members WHERE username = ?";

    statement.setString(1, username);
    rs = statement.executeQuery();

    if (rs.next()) {
        if (rs.getBoolean("user_is_current") {
            return Response.status(200).build();
        } else {
            return Response.status(404).entity("Expired").build();
        }
    }
}