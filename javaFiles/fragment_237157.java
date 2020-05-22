public static PublicKey getPublicKey(
                    String filePath)
                    throws PGPException, NoSuchProviderException, FileNotFoundException, IOException
                {
                    PGPPublicKey    encKey = readPublicKey(new FileInputStream(filePath));
                    return new JcaPGPKeyConverter().setProvider("BC").getPublicKey(encKey);
                }




                public static PrivateKey getPrivateKey( 
                        InputStream    in, char[]      passwd) 
                        throws IOException, PGPException, NoSuchProviderException 
                    { 
                        in = PGPUtil.getDecoderStream(in); 

                        PGPSecretKeyRingCollection        pgpSec = new PGPSecretKeyRingCollection(in); 

                        // 
                        // we just loop through the collection till we find a key suitable for encryption, in the real 
                        // world you would probably want to be a bit smarter about this. 
                        // 

                        // 
                        // iterate through the key rings. 
                        // 
                        Iterator<?> rIt = pgpSec.getKeyRings(); 

                        while (rIt.hasNext()) 
                        { 
                            PGPSecretKeyRing    kRing = (PGPSecretKeyRing)rIt.next();     
                            Iterator<?>                        kIt = kRing.getSecretKeys(); 

                            while (kIt.hasNext()) 
                            { 
                                PGPSecretKey    k = (PGPSecretKey)kIt.next(); 

                                if (k != null) 
                                { 
                                    PGPPrivateKey pk = k.extractPrivateKey(passwd, "BC"); 
                                     return new JcaPGPKeyConverter().setProvider("BC").getPrivateKey(pk);
                                } 
                            } 
                        } 

                        throw new IllegalArgumentException("Can't find secured key in key ring."); 
                    } 

                public static PGPPublicKey readPublicKey( 
                        InputStream    in) 
                        throws IOException, PGPException 
                    { 
                        in = PGPUtil.getDecoderStream(in); 

                        PGPPublicKeyRingCollection        pgpPub = new PGPPublicKeyRingCollection(in); 

                        // 
                        // we just loop through the collection till we find a key suitable for encryption, in the real 
                        // world you would probably want to be a bit smarter about this. 
                        // 

                        // 
                        // iterate through the key rings. 
                        // 
                        Iterator<?> rIt = pgpPub.getKeyRings(); 

                        while (rIt.hasNext()) 
                        { 
                            PGPPublicKeyRing    kRing = (PGPPublicKeyRing)rIt.next();     
                            Iterator<?>                        kIt = kRing.getPublicKeys(); 

                            while (kIt.hasNext()) 
                            { 
                                PGPPublicKey    k = (PGPPublicKey)kIt.next(); 

                                if (k.isEncryptionKey()) 
                                { 
                                    return k; 
                                } 
                            } 
                        } 

                        throw new IllegalArgumentException("Can't find encryption key in key ring."); 
                    }