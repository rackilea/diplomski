/* Create the encrypter */
SMIMEEnvelopedGenerator encrypter = new SMIMEEnvelopedGenerator();
encrypter.addKeyTransRecipient((X509Certificate) recipient1Cert);
encrypter.addKeyTransRecipient((X509Certificate) recipient2Cert);

/* Encrypt the MimeMessage*/
MimeBodyPart encryptedPart = encrypter.generate(signedMessage,
SMIMEEnvelopedGenerator.RC2_CBC, "BC");