repository.registerLoginHandler(repo -> new ILoginInfo() {
    public String getUserId() {
        return "username";
    }
    public String getPassword() {
        return "pass";                        
    }
});