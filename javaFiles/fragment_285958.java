KeyStore keystore = KeyStore.getInstance("PKCS12", "BC");
        keystore.load (new FileInputStream(PATH+"//test.p12"), "testpassword".toCharArray());
        PrivateKey privateKey = (PrivateKey)keystore.getKey("testclientcert", "testpassword".toCharArray());

        PEMReader pemReader = new PEMReader(new FileReader(filename));
        ContentInfo object = (ContentInfo)pemReader.readObject();

        CMSEnvelopedDataParser envDataParser = new CMSEnvelopedDataParser(object.getEncoded());
        RecipientInformationStore recipients = envDataParser.getRecipientInfos();
        Collection envCollection = recipients.getRecipients();
        Iterator it = envCollection.iterator();
        RecipientInformation recipient = (RecipientInformation) it.next();
        byte[] result = recipient.getContent(privateKey, "BC");
        String base64Encoded = new String(Base64.encode(result));

        System.out.println(base64Encoded);