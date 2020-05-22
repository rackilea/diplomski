private BooleanProperty loggedIn = new SimpleBooleanProperty();

// ...

public void expireCredentials() {
    loggedIn.set(false);
}