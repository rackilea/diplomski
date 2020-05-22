final CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

final X509Certificate certificateToCheck = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(certBytes));

final KeyStore trustStore = KeyStore.getInstance("JKS");
InputStream keyStoreStream = ...
trustStore.load(keyStoreStrem, "your password".toCharArray());

final CertPathBuilder certPathBuilder = CertPathBuilder.getInstance("PKIX");
final X509CertSelector certSelector = new X509CertSelector();
certSelector.setCertificate(certificateToCheck);

final CertPathParameters certPathParameters = new PKIXBuilderParameters(trustStore, certSelector);
final CertPathBuilderResult certPathBuilderResult = certPathBuilder.build(certPathParameters);
final CertPath certPath = certPathBuilderResult.getCertPath();

final CertPathValidator certPathValidator = CertPathValidator.getInstance("PKIX");
final PKIXParameters validationParameters = new PKIXParameters(trustStore);
validationParameters.setRevocationEnabled(true); // if you want to check CRL
final X509CertSelector keyUsageSelector = new X509CertSelector();
keyUsageSelector.setKeyUsage(new boolean[] { true, false, true }); // to check digitalSignature and keyEncipherment bits
validationParameters.setTargetCertConstraints(keyUsageSelector);
final PKIXCertPathValidatorResult result = (PKIXCertPathValidatorResult) certPathValidator.validate(certPath, validationParameters);

System.out.println(result);