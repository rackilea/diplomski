String query = "SELECT src_big "
                            + "FROM photo "
                            + "WHERE aid IN "
                            + "(SELECT aid "
                                + "FROM album "
                                + "WHERE name = " + "\"" + albumname + "\" AND owner IN "
                                    + "(SELECT uid "
                                    + "FROM user "
                                    + "WHERE username = " + "\"" + username + "\"))";

// Single FQL
mPhotos = facebook.executeFQL(query);