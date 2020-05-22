Document document = new Document();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
PdfWriter.getInstance(document, baos);
document.open();
document.add(new Paragraph("Hello World!"));
document.close();


    PdfReader reader = new PdfReader(baos.toByteArray());
    OutputStream os = new FileOutputStream("c:\\temp\\sign\\test.pdf");
    PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0');

    // Creating the appearance
    PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
    appearance.setReason("REASON");
    appearance.setLocation("LOCATION");

    appearance.setVisibleSignature(new Rectangle(36, 748, 144, 780), 1, "sig");

    Security.addProvider(new BouncyCastleProvider());

    FileInputStream fis = new FileInputStream("c:\\ssl\\test.pfx");
    String password = "myPassword";

    KeyStore ks = KeyStore.getInstance("pkcs12");
    ks.load(fis, password.toCharArray());
    String alias = ks.aliases().nextElement();

    PrivateKey pk = (PrivateKey) ks.getKey(alias, password.toCharArray());
    X509Certificate cert = (X509Certificate) ks.getCertificate(alias);

    TSAClient tsc = new TSAClientBouncyCastle("http://timestampserverURL/");
    ExternalDigest digest = new BouncyCastleDigest();
    ExternalSignature signature = new PrivateKeySignature(pk, "SHA-1", "BC");
    MakeSignature.signDetached(appearance, digest, signature, new Certificate[] { cert }, null, null, tsc, 0,
            CryptoStandard.CMS);