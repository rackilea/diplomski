public ExampleKeyImpl() {
     keyPair = new KeyPair(KeyPair.ALG_EC_FP, KeyBuilder.LENGTH_EC_FP_192);

     Secp192r1.setCommonCurveParameters((ECKey) keyPair.getPrivate());
     Secp192r1.setCommonCurveParameters((ECKey) keyPair.getPublic());
}