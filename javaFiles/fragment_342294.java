protected Object hashProvidedCredentials(AuthenticationToken token, AuthenticationInfo info) {
    Object salt = null;
    if (info instanceof SaltedAuthenticationInfo) {
        salt = ((SaltedAuthenticationInfo) info).getCredentialsSalt();

        // Get base64 Decoder
        java.util.Base64.Decoder Decoder = java.util.Base64.getDecoder();
        // decode salt from database
        byte[] encodedJava8 = null;
        encodedJava8 = Decoder.decode(((SaltedAuthenticationInfo) info).getCredentialsSalt().getBytes());
        // save decoded salt value in previous salt Object
        salt = ByteSource.Util.bytes(encodedJava8);

        // The 3 steps above are nessecary because the Object salt is of type 
        // SimpleByteSource and:
        // - it holds a byte[] which holds the salt in its correct form
        // - it also holds a cachedBase64 encoded version of this byte[]
        //   (which is of course not the actual salt)

        // The Problem is that the next method call below that hashes the
        // submitted password uses the cachedBase64 value to hash the
        // passwort and not the byte[] which represents the actual salt

        // Therefor it is nessecary to:
        // - create SimpleByteSource salt with the value from the database
        // - decode the byte[] so that the cachedBase64 represents the actual salt
        // - store the decoded version of the byte[] in the SimpleByteSource variable salt
    } else {
        //retain 1.0 backwards compatibility:
        if (isHashSalted()) {
            salt = getSalt(token);
        }
    }
    return hashProvidedCredentials(token.getCredentials(), salt, getHashIterations());
}