// for test, (own) signing key+certchain and (peer) encryption cert in file
    KeyStore ks = KeyStore.getInstance("JKS"); ks.load(new FileInputStream(args[0]),args[1].toCharArray());
    PrivateKey signkey = (PrivateKey) ks.getKey(args[2], args[1].toCharArray());
    Certificate[] signcert = ks.getCertificateChain(args[2]);
    Certificate encrcert = ks.getCertificate(args[3]);
    // and data in file
    byte[] data = Files.readAllBytes(new File(args[4]).toPath());

    // adapted from org.bouncycastle.mail.smime.examples.CreateSignedMail 
    // OpenSSL uses this rather silly capability list; may not be needed 
    SMIMECapabilityVector       caps = new SMIMECapabilityVector();
    caps.addCapability(SMIMECapability.aES256_CBC);
    caps.addCapability(SMIMECapability.aES192_CBC);
    caps.addCapability(SMIMECapability.aES128_CBC);
    caps.addCapability(SMIMECapability.dES_EDE3_CBC);
    caps.addCapability(SMIMECapability.rC2_CBC, 128);
    caps.addCapability(SMIMECapability.rC2_CBC, 64);
    caps.addCapability(SMIMECapability.dES_CBC);
    caps.addCapability(SMIMECapability.rC2_CBC, 40);
    ASN1EncodableVector signedAttrs = new ASN1EncodableVector();
    signedAttrs.add(new SMIMECapabilitiesAttribute(caps));
    // Bouncy default adds RFC6211 in addition to standard ctype, stime, mdgst
    // and changing this is complicated; recipient _should_ ignore unneeded attr

    SMIMESignedGenerator gen = new SMIMESignedGenerator();
    gen.addSignerInfoGenerator(new JcaSimpleSignerInfoGeneratorBuilder()//.setProvider("BC") not needed
        .setSignedAttributeGenerator(new AttributeTable(signedAttrs))
        .build("SHA1withRSA", signkey, (X509Certificate) signcert[0]) ); 
    // change sigalg if key not RSA and/or want better hash
    // OpenSSL by default includes only signer cert; recipient may want more
    gen.addCertificates(new JcaCertStore (Arrays.asList (new Certificate[]{signcert[0]}) ));

    MimeBodyPart msg = new MimeBodyPart();
    msg.setText(new String(data, "ISO-8859-1")); // OpenSSL doesn't know charsets
    ByteArrayOutputStream temp = new ByteArrayOutputStream();
    gen.generateEncapsulated(msg).writeTo(temp); // OpenSSL -nodetach is encapsulated
    // Bouncy uses BER here (unlike OpenSSL DER) 
    // and I don't see a simple way to change it but it _should_ not matter 
    byte[] signedblob = temp.toByteArray();

    // now CMS (not SMIME) enveloping
    CMSEnvelopedDataGenerator edgen = new CMSEnvelopedDataGenerator();
    edgen.addRecipientInfoGenerator(new JceKeyTransRecipientInfoGenerator((X509Certificate) encrcert));
    CMSEnvelopedData edmsg = edgen.generate( new CMSProcessableByteArray(signedblob),
            new JceCMSContentEncryptorBuilder(CMSAlgorithm.DES_EDE3_CBC).build() );
    byte[] encrblob = edmsg.toASN1Structure().getEncoded(ASN1Encoding.DER); // OpenSSL is DER though std doesn't require it

    // for test, write to a file
    Files.write(new File(args[5]).toPath(), encrblob);