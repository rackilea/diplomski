KeyFactory keyFactory = KeyFactory.getInstance("ECDSA", "BC");
    ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("secp256k1");

    ECPoint Q = ecSpec.getG().multiply(((org.bouncycastle.jce.interfaces.ECPrivateKey) this.privateKey).getD());

    ECPublicKeySpec pubSpec = new ECPublicKeySpec(Q, ecSpec);
    PublicKey publicKeyGenerated = keyFactory.generatePublic(pubSpec);
    this.publicKey = publicKeyGenerated;