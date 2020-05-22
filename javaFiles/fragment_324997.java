private ObjectProperty<Credentials> credentials = new SimpleObjectProperty<>();

// ...

public void expireCredentials() {
    credentials.set(null);
}

// ...

submitSecureDataButton.disableProperty().bind(credentials.isNull());
loginButton.disableProperty().bind(credentials.isNotNull());