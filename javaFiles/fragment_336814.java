SMIMEEnvelopedGenerator gen = new SMIMEEnvelopedGenerator();
JceKeyAgreeRecipientInfoGenerator rig = new JceKeyAgreeRecipientInfoGenerator(CMSAlgorithm.ECDH_SHA1KDF, senderPrivateKey, senderPublicKey, CMSAlgorithm.AES128_WRAP);
rig.setProvider("BC");
gen.addRecipientInfoGenerator(rig);

MimeBodyPart msg = new MimeBodyPart();
msg.setText("This is a secret message");

MimeBodyPart mp = gen.generate(msg, new JceCMSContentEncryptorBuilder(CMSAlgorithm.AES128_CBC).setProvider("BC").build());

Properties props = System.getProperties();
Session session = Session.getDefaultInstance(props, null);

String to = "bob@example.com";

Address fromUser = new InternetAddress("alice@example.com");
Address toUser = new InternetAddress(to);

MimeMessage body = new MimeMessage(session);
body.setFrom(fromUser);
body.setRecipient(Message.RecipientType.TO, toUser);
body.setSubject("example encrypted message");
body.setContent(mp.getContent(), mp.getContentType());
body.saveChanges();

body.writeTo(new FileOutputStream("/tmp/encrypted.msg"));