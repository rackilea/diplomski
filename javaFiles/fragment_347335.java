public String encode(CharSequence rawPassword) {
    String salt;
    if (strength > 0) {
        if (random != null) {
            salt = BCrypt.gensalt(strength, random);
        }
        else {
            salt = BCrypt.gensalt(strength);
        }
    }
    else {
        salt = BCrypt.gensalt();
    }
    return BCrypt.hashpw(rawPassword.toString(), salt);
}