public static class EncryptString implements UDF1<String, String> {

    private final String password; 

    public EncryptString(String password) {
        this.password = password;
    }

    public String call(String s) throws Exception { 
        return Aes256.encrypt(s, password);
    }
}