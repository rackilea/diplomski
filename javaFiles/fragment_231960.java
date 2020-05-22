public boolean verify(GoogleIdToken googleIdToken) throws GeneralSecurityException, IOException {
    // check the payload
    if (!super.verify(googleIdToken)) {
      return false;
    }
    // verify signature
    for (PublicKey publicKey : publicKeys.getPublicKeys()) {
      try {
        if (googleIdToken.verifySignature(publicKey)) {
            return true;
          }
    } catch (Exception e) {
        System.err.println("Verify Token:" + e);
    }
    }
    return false;
  }