class Search {
    Search(String username, JSONObject accounts, Credentials creds) throws Exception {
        Credentials credentials = creds? creds : new Credentials(username);
        String Uid = credentials.getUserName();
        String Pwd = new String(credentials.getCredentials().getPassword());
    }
    Search(String username, JSONObject accounts) throws Exception {
        this(username, accounts, null);
    }
}