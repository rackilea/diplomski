gen.addSignerInfoGenerator(
            new JcaSignerInfoGeneratorBuilder(
                 new JcaDigestCalculatorProviderBuilder().setProvider("BC").build())
                 .build(sha1Signer, certificate));

// use this to add the certificates to your signature
gen.addCertificates(certs);

signedData = gen.generate(cmsBytes, true);