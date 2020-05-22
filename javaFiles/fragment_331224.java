CMSSignedDataGenerator generator = new CMSSignedDataGenerator();
signer = new JcaContentSignerBuilder("SHA1withRSA").build(cakey);
generator.addSignerInfoGenerator(new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().build()).build(signer, cacert));
generator.addCertificate(new X509CertificateHolder(certencoded));
generator.addCertificate(new X509CertificateHolder(cacert.getEncoded()));
CMSTypedData content = new CMSProcessableByteArray(certencoded);
CMSSignedData signeddata = generator.generate(content, true);
byte signedCertificate[] = signeddata.getEncoded();