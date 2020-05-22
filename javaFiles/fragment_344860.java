KeyFactory keyFactory = KeyFactory.getInstance("RSA");

    RSAPrivateKeySpec privateKeySpec = new RSAPrivateKeySpec(
            new BigInteger("57791d5430d593164082036ad8b29fb157791d5430d593164082036ad8b29fb157791d5430d593164082036ad8b29fb157791d5430d593164082036ad8b29fb1", 16),
            new BigInteger("57791d5430d593164082036ad8b29fb157791d5430d593164082036ad8b29fb157791d5430d593164082036ad8b29fb157791d5430d593164082036ad8b29fb1", 16)
    );

    RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);