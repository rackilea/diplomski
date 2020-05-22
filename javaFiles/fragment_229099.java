Provider provider = Security.getProvider("SunMSCAPI");
CallbackHandler cbh = // your implementation
KeyStore.ProtectionParameter protection = new KeyStore.CallbackHandlerProtection(cbh);
//get a handle of the CAPI KeyStore as before
KeyStore.Builder keystoreBuilder = KeyStore.Builder.newInstance("Windows-MY",
                                                                provider, 
                                                                protection);
KeyStore store = keystoreBuilder.getKeyStore();