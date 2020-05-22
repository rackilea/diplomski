public byte[] sign(final InputStream content) throws SignatureException,
      IOException {
    try {
      CMSTypedData input = new CMSProcessableByteArray(
          IOUtils.toByteArray(content));
      List<Certificate> certList = Arrays.asList(keystore
          .getCertificateChain(alias));
      Store certs = new JcaCertStore(certList);
      CMSSignedDataGenerator gen = new CMSSignedDataGenerator();
      ContentSigner shaSigner = new JcaContentSignerBuilder("SHA256withRSA")
          .setProvider("BC").build((PrivateKey) keystore.getKey(alias, pin));
      gen.addSignerInfoGenerator(new JcaSignerInfoGeneratorBuilder(
          new JcaDigestCalculatorProviderBuilder().setProvider("BC").build())
          .build(shaSigner, (X509Certificate) keystore.getCertificate(alias)));
      gen.addCertificates(certs);
      return gen.generate(input, false).getEncoded();
    } catch (Exception e) {
      throw new SignatureException(
          "Problem while preparing signature. Wrong certificate or alias.");
    }
  }