public static class ProtoQuery<T> {
    public String action;
    public String token;
    public T params;

    public ProtoQuery(String action, String token, T params) {
        this.action = action;
        this.token = token;
        this.params = params;
    }
}


// Authentication Phase
public static class ProtoAuth {
    public String username;
    public String password;

    public ProtoAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }
}