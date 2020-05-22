public ExampleKeyImpl() {
     keyPair = new KeyPair(
             (ECPublicKey) KeyBuilder.buildKey(KeyBuilder.TYPE_EC_FP_PUBLIC, KeyBuilder.LENGTH_EC_FP_192, false),
             (ECPrivateKey) KeyBuilder.buildKey(KeyBuilder.TYPE_EC_FP_PRIVATE, KeyBuilder.LENGTH_EC_FP_192, false));

     Secp192r1.setCommonCurveParameters((ECKey) keyPair.getPrivate());
     Secp192r1.setCommonCurveParameters((ECKey) keyPair.getPublic());
 }