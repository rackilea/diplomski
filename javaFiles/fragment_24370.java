interface Credentials {
    @NonNull
    String getPassword();

    void setPassword(@NonNull password);
}

// Allows null password
class GoodCreds implements Credentials {
    // but cannot widen; throw exception for null instead
    @Overrides
    @NonNull
    String getPassword() {...}

    // can widen parameters
    @Overrides
    void setPassword(@CheckForNull password) {...}
}