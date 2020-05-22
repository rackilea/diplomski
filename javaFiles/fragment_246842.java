byte[] pubkeyder = Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCMnFkJTMZ2ZxnqLwCiB/EWHjsHbnC+sKEIrGbyOTYiTl3LygsekAX6LhgcllscLUFqSKlMRB3jRB0GAPrIc73E/hTnmWBtF8NT8DhZzl06LZ1BtNjfON1pHm87STMAayiSaXPmSOwIqOA89aJPcA9m4v4IhtjYSFXmCAsE4RqoAwIDAQAB");
MessageDigest sha1 = MessageDigest.getInstance("SHA1");
// method 1
byte[] x1 = sha1.digest (Arrays.copyOfRange(pubkeyder, 22, pubkeyder.length));
System.out.println (new String(b32enc(Arrays.copyOf(x1,10))).toLowerCase());
// method 2
byte[] x2 = sha1.digest (SubjectPublicKeyInfo.getInstance(pubkeyder).getPublicKeyData().getOctets());
System.out.println (new String(b32enc(Arrays.copyOf(x2,10))).toLowerCase());
-> 
qqkhrc4men3fiqyl
qqkhrc4men3fiqyl