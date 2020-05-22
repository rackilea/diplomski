String createUserProfile = "CREATE TABLE if not exists aaron.userprofiles ("
        + "      login text PRIMARY KEY,"
        + "      password text,"
        + "      firstname text,"
        + "      lastname text,"
        + "      email text,"
        + "      picid uuid);";