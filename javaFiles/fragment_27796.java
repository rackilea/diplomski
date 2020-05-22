package sandbox.package2;

import sandbox.pakcage1.Player;

class User extends Player {
    private String userID;

    public User(String name, String id) {
        super(name);
        this.userID = id;
    }

    public String getUserID() {
        return userID;
    }
}