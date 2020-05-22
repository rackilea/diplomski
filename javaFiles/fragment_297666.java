public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
    String pass1 = encPass + "";

    // Strict delimiters is false because pass2 never persisted anywhere
    // and we want to avoid unnecessary exceptions as a result (the
    // authentication will fail as the encodePassword never allows them)
    String pass2 = mergePasswordAndSalt(rawPass, salt, false);

    if (ignorePasswordCase) {
        // Note: per String javadoc to get correct results for Locale insensitive, use English
        pass1 = pass1.toLowerCase(Locale.ENGLISH);
        pass2 = pass2.toLowerCase(Locale.ENGLISH);
    }
    return PasswordEncoderUtils.equals(pass1,pass2);
}