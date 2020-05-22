PrivateKey privKey = (PrivateKey) windowsCertRep.getPrivateKey(this.selected_alias, "changeit");
    X509Certificate[] certificateChain = windowsCertRep.getCertificateChain(this.selected_alias);

        List<X509Certificate> certList = Arrays.asList(certificateChain);
        JcaCertStore certs = new JcaCertStore(certList);

        CMSSignedDataGenerator gen = new CMSSignedDataGenerator();

        Attribute attr = new Attribute(CMSAttributes.messageDigest,
                new DERSet(new DEROctetString(hash)));

        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(attr);

        SignerInfoGeneratorBuilder builder = new SignerInfoGeneratorBuilder(new BcDigestCalculatorProvider())
                .setSignedAttributeGenerator(new DefaultSignedAttributeTableGenerator(new AttributeTable(v)));

        AlgorithmIdentifier sha256withRSA = new DefaultSignatureAlgorithmIdentifierFinder().find("SHA256withRSA");

        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        InputStream in = new ByteArrayInputStream(certificateChain[0].getEncoded());
        X509Certificate cert = (X509Certificate) certFactory.generateCertificate(in);

        ContentSigner sha256Signer = new JcaContentSignerBuilder("SHA256WithRSA").build(privKey);
        gen.addSignerInfoGenerator(builder.build(sha256Signer, new JcaX509CertificateHolder(cert)));

        gen.addCertificates(certs);

        CMSSignedData s = gen.generate(new CMSAbsentContent(), false);
        return s.getEncoded();