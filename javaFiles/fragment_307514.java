public boolean checkPassword(String passwordText, String DbHash) {
    boolean password_verified = false;
    if (null == DbHash || !DbHash.startsWith("$2a$")) {
        throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
    }
    password_verified = BCrypt.checkpw(passwordText, DbHash);
    return (password_verified);
 }