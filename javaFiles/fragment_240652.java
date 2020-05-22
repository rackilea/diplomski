Enumeration enumeration = keystore.aliases();
 while(enumeration.hasMoreElements()) {
        String alias = (String)enumeration.nextElement();
        X509Certificate certificate = (X509Certificate) keystore.getCertificate(alias);
        BigInteger serialNumber = certificate.getSerialNumber()

    }