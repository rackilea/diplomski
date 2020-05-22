String publicK = "-----BEGIN PUBLIC KEY-----\n"
            + "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgFhTDtuYJ5G5LEHMesnf\n"
            + "wX9cXZ1b/ozkkpbgtC3ziETiFkOFncbPCskpdbPmXxXv3vrwJ2RQIL2LZLZPe1xT\n"
            + "AyQY1DdD8hGqIemMwV2NqfFoEomVL5+QOAKCRiHkGgte6a2+OoTk9JzRP/NVaPkB\n"
            + "sdX1/nIPERYen3uDvUSYq83Ite2oDyaZZxj+/r46SadS/g5jWmeqgVoInJw813y7\n"
            + "Ee2HgYVbnktlLNhqIGj+1OKmwop+GP7Kk5CAkt9fo4VjRRllDaX1yFCZEbDL254n\n"
            + "S+LVOhl4mLBM8764+YVxjyYRC1Nq2rNZfQ602652i+l8u8nGqdiKOKDpjNDvhONP\n" + "yQIDAQAB\n"
            + "-----END PUBLIC KEY-----";

    String pubKeyPEM = publicK.replace("-----BEGIN PUBLIC KEY-----\n", "").replace("-----END PUBLIC KEY-----", "");

    // Base64 decode the data

    byte[] encodedPublicKey = Base64.decode(pubKeyPEM);

    X509EncodedKeySpec spec = new X509EncodedKeySpec(encodedPublicKey);
    KeyFactory kf = KeyFactory.getInstance("RSA");
    System.out.println(kf.generatePublic(spec));