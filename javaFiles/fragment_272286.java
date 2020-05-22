InputStream ksInStream = getResources().openRawResource(R.raw.elalkeystore);

KeyStore ks = KeyStore.getInstance("BKS");
ks.load(ksInStream, keystorePasswordCharArray);
Certificate cert = ks.getCertificate("entryAlias");
ksInStream.close();