/**
     * This method encodes the plaintext user password according to RFC 2865.
     * 
     * @param userPass
     *            the password to encrypt
     * @param sharedSecret
     *            shared secret
     * @return the byte array containing the encrypted password
     */
    private byte[] encodePapPassword(final byte[] userPass, byte[] sharedSecret) {
        // the password must be a multiple of 16 bytes and less than or equal
        // to 128 bytes. If it isn't a multiple of 16 bytes fill it out with zeroes
        // to make it a multiple of 16 bytes. If it is greater than 128 bytes
        // truncate it at 128.


    if (userPass == null) {
        throw new IllegalArgumentException("password is null");
    } else if (sharedSecret == null) {
        throw new IllegalArgumentException("shared secret is null");
    } else if (getAuthenticator() == null) {
        throw new IllegalArgumentException("authenticator is null");
    }

    byte[] userPassBytes = null;
    if (userPass.length > 128) {
        userPassBytes = new byte[128];
        System.arraycopy(userPass, 0, userPassBytes, 0, 128);
    } else {
        userPassBytes = userPass;
    }
    // declare the byte array to hold the final product
    byte[] encryptedPass = null;
    if (userPassBytes.length < 128) {
        if (userPassBytes.length % 16 == 0) {
            // tt is already a multiple of 16 bytes
            encryptedPass = new byte[userPassBytes.length];
        } else {
            // make it a multiple of 16 bytes
            encryptedPass = new byte[((userPassBytes.length / 16) * 16) + 16];
        }
    } else {
        // the encrypted password must be between 16 and 128 bytes
        encryptedPass = new byte[128];
    }
    // copy the userPass into the encrypted pass and then fill it out with zeroes
    System.arraycopy(userPassBytes, 0, encryptedPass, 0, userPassBytes.length);
    for (int i = userPassBytes.length; i < encryptedPass.length; i++) {
        encryptedPass[i] = 0;
    }
    // digest shared secret and authenticator
        MessageDigest md5 = getMd5Digest();

    md5.reset();
    byte[] bn = new byte[sharedSecret.length + getAuthenticator().length];
    for (int i = 0; i < bn.length; i++) {
        if (i < sharedSecret.length)
            bn[i] = sharedSecret[i];
        else
            bn[i] = getAuthenticator()[i - sharedSecret.length];
    }
    md5.update(bn);
    bn = md5.digest();
    // perform the XOR as specified by RFC 2865
    for (int i = 0; i < 16; i++) {
        encryptedPass[i] = (byte) (bn[i] ^ encryptedPass[i]);
    }
    if (encryptedPass.length > 16) {
        for (int i = 16; i < encryptedPass.length; i += 16) {
            md5.reset();
            md5.update(sharedSecret);
            // add the previous (encrypted) 16 bytes of the user password
            md5.update(encryptedPass, i - 16, 16);
            bn = md5.digest();
            // perform the XOR as specified by RFC 2865.
            for (int j = 0; j < 16; j++) {
                encryptedPass[i + j] = (byte) (bn[j] ^ encryptedPass[i + j]);
            }
        }
    }
    return encryptedPass;
}

    /**
     * Decodes the passed encrypted password and returns the clear-text form.
     *
     * @param encryptedPass
     *            encrypted password
     * @param sharedSecret
     *            shared secret
     * @return decrypted password
     */
    private String decodePapPassword(byte[] encryptedPass, byte[] sharedSecret) throws RadiusException {
        if (encryptedPass == null) {
            throw new IllegalArgumentException("encrypted password is null");
        } else if (sharedSecret == null) {
            throw new IllegalArgumentException("shared secret is null");
        } else if (getAuthenticator() == null) {
            throw new IllegalArgumentException("authenticator is null");
        } else if (encryptedPass.length < 16) {
            throw new IllegalArgumentException("invalid length of encrypted pass: " + encryptedPass.length);
        }

        // save original (encoded) encrypted pass
        byte[] encryptedPassOrig = encryptedPass.clone();
    //  MessageDigest md5;
        MessageDigest md5 = getMd5Digest();
        md5.reset();
        md5.update(sharedSecret);
        md5.update(getAuthenticator());
        byte bn[] = md5.digest();
        // perform the XOR as specified by RFC 2865
        for (int i = 0; i < 16; i++) {
            encryptedPass[i] = (byte) (bn[i] ^ encryptedPass[i]);
        }
        if (encryptedPass.length > 16) {
            for (int i = 16; i < encryptedPass.length; i += 16) {
                md5.reset();
                md5.update(sharedSecret);
                // now use original (encoded) pass to generate MD5
                md5.update(encryptedPassOrig, i - 16, 16);
                bn = md5.digest();
                // perform the XOR as specified by RFC 2865.
                for (int j = 0; j < 16; j++) {
                    encryptedPass[i + j] = (byte) (bn[j] ^ encryptedPass[i + j]);
                }
            }
        }
        // remove trailing zeros
        int len = encryptedPass.length;
        while (len > 0 && encryptedPass[len - 1] == 0) {
            len--;
        }

        byte[] passtrunc = new byte[len];
        System.arraycopy(encryptedPass, 0, passtrunc, 0, len);
        // convert to string
        return RadiusUtil.getStringFromUtf8(passtrunc);
    }