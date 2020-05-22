String createFriendsTable =
          "CREATE TABLE Friends("
        + "personId     INT NOT NULL, "
        + "friendId     INT NOT NULL, "
        + "status       VARCHAR2(50) NOT NULL, "
        + "PRIMARY KEY (personId, friendId), "
        + "FOREIGN KEY (personId) REFERENCES Persons(personId), "
        + "FOREIGN KEY (friendId) REFERENCES Persons(personId), "           
                                                              ^
        + ")";