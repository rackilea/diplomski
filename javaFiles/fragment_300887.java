try {
    conn = LicenseDBSource.getInstance().getConnection();
    statement = conn.prepareStatement(
        "SELECT " + 
        "   EXISTS (SELECT * FROM members WHERE username = ?) AS user_exists, " +
        "   EXISTS (SELECT * FROM members WHERE username = ? " + 
                       " AND LOCALTIMESTAMP < expiration) AS user_is_current" ;
    statement.setString(1, username);
    statement.setString(2, username);
    rs = statement.executeQuery();
    rs.next(); // There will *always* be one row
    if (rs.getBoolean("user_exists")) {
        if (rs.getBoolean("user_is_current") {
            return Response.status(200).build();
        } else {
            return Response.status(404).entity("Expired").build();
        }
    }