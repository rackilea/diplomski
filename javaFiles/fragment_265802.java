"SELECT M2.messageProfileId, profiles.profileMiniature, profiles.firstName, profiles.lastName, profiles.timeFormat, lastMessages.message, lastMessages.timeStamp " +
                "FROM   (" +
                "       SELECT IF(M1.fromProfileId = ?, M1.toProfileId, M1.fromProfileId) AS messageProfileId, " +
                "           max(M1.timeStamp) AS lastMessageTime " +
                "       FROM messages AS M1 " +
                "       WHERE (M1.toProfileId = ? " +
                "       OR M1.fromProfileId = ?) " +
                "       GROUP BY IF(M1.fromProfileId = ?, M1.toProfileId, M1.fromProfileId) " +
                "       ORDER BY max(M1.timeStamp) DESC " +
                "       LIMIT 10 " +
                "       ) AS M2 " +
                "INNER JOIN messages AS lastMessages " +
                "ON     (" +
                "       lastMessages.timeStamp = M2.lastMessageTime " +
                "AND    (" +
                "       lastMessages.fromProfileId = M2.messageProfileId " +
                "OR     lastMessages.toProfileId = M2.messageProfileId " +
                "       )" +
                "       )" +
                "INNER JOIN profiles " +
                "ON M2.messageProfileId = profiles.profileId ";