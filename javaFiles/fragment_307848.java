interface Authentication<T extends Credentials> {
    public User createUser(T c);
}


class MyAuthentication implements Authentication<MyCredentials> {

    @Override
    public User createUser(MyCredentials c) {
        // ...
    }
}