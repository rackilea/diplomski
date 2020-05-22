PdfStamper stamper = PdfStamper.createSignature(...);

AdobeLtvEnabling adobeLtvEnabling = new AdobeLtvEnabling(stamper);
OcspClient ocsp = new OcspClientBouncyCastle();
CrlClient crl = new CrlClientOnline();
adobeLtvEnabling.addLtvForChain(YOUR_SIGNER_CERTIFICATE, ocsp, crl, PdfName.A);
adobeLtvEnabling.outputDss();

[...preparing your signature...]
MakeSignature.signDetached(...);