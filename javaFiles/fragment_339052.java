private  void savePublicKeyToFile(String fileName,
                                BigInteger mod, BigInteger exp) throws IOException {
     ObjectOutputStream oout = new ObjectOutputStream(
             new BufferedOutputStream(new FileOutputStream(fileName)));
     try {
         oout.writeObject(mod);
         oout.writeObject(exp);
     } catch (Exception e) {
        // throw new SomeException(e);
     } finally {
         oout.close();
     }
 }

  private  void savePrivteKeyToFile(String fileName,
                                BigInteger mod, BigInteger PublicExponent, BigInteger PrivateExponent,
            BigInteger PrimeP, BigInteger PrimeQ,BigInteger PrimeExponentP,BigInteger PrimeExponentQ,
            BigInteger CrtCoefficient) throws IOException {
     ObjectOutputStream oout = new ObjectOutputStream(
             new BufferedOutputStream(new FileOutputStream(fileName)));
     try {
         oout.writeObject(mod);
         oout.writeObject(PublicExponent);
         oout.writeObject(PrivateExponent);
         oout.writeObject(PrimeP);
         oout.writeObject(PrimeQ);
         oout.writeObject(PrimeExponentP);
         oout.writeObject(PrimeExponentQ);
         oout.writeObject(CrtCoefficient);
     } catch (Exception e) {
        // throw new SomeException(e);
     } finally {
         oout.close();
     }
 }


     // To save in keystore here is the way


     Certificate [] certChain = new Certificate[1];
    certChain[0] = ca;
    String strAlias = "abcalias", strPassword="mypass";
    KeyStore keyStore = KeyStore.getInstance("jks");
    keyStore.load(null,strPassword.toCharArray());
    keyStore.setEntry(strAlias,
       new KeyStore.PrivateKeyEntry((PrivateKey) KPair.getPrivate(), certChain),
       new KeyStore.PasswordProtection(strPassword.toCharArray()));

    FileOutputStream fkey = new FileOutputStream(strFilePath+".keystore"); 
    keyStore.store(fkey, strPassword.toCharArray());
    fkey.close();