public void addUserPosition(UserPosition userPosition) {
    userPositionCollection.add(userPosition);
    userPosition.setUser(this);
}

public void addDefaultUserPosition(UserPosition userPosition) {
    defaultUserPosition = userPosition;
    userPosition.setDefaultUserPosition(this);
}