try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        uuid = UUID.randomUUID();
        create.insertInto(ACCOUNTS, ACCOUNTS.ID, ACCOUNTS.ONESIGNAL_ID, ACCOUNTS.EMAIL, ACCOUNTS.AGE, ACCOUNTS.UUID_L, ACCOUNTS.UUID_M)
              .values(userId, oneSignalId, email, (int)age, uuid.getLeastSignificantBits(), uuid.getMostSignificantBits())
              .execute();
} catch (SQLException e) { 
    e.printStackTrace(); 
}