if (strProviderType.length() > 0) {
    strSql += " and users.usertype IN (?)";
}

try (PreparedStatement oPrepStmt = oRoot.con.prepareStatement(strSql)) {
    oPrepStmt.setInt(1,oRoot.getTrUserId());
    if (strProviderType.length() > 0) {
        oPrepStmt.setString(2, strProviderType);
    }

    oPrepStmt.execute(); // or executeQuery or executeUpdate
}