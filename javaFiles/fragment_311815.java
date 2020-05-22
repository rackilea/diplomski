CMSSignedDataGenerator gen = new CMSSignedDataGenerator();
        Certificate [] chain = certificate.getCertificateChain();
        try {
            CMSProcessableByteArray msg = new CMSProcessableByteArray("".getBytes());
            JcaCertStore store = new JcaCertStore(Arrays.asList(chain));
            gen.addCertificates(store);
            CMSSignedData signedData = gen.generate(msg);
            return signedData.getEncoded();
        } catch (Exception ex) {
            logger.error("Failed to construct P7B response",ex);
            throw new RuntimeException(ex);
        }