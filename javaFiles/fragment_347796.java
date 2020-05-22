// The key with which you want to verify the cert.
// This is probably a CA certificate's public key.
PublicKey publicKey = ...;

PEMReader reader = new PEMReader(new FileReader("/path/to/file.pem"));
Object pemObject = reader.readObject();
if (pemObject instanceof X509Certificate) {
    X509Certificate cert = (X509Certificate)pemObject;
    cert.checkValidity(); // to check it's valid in time
    cert.verify(publicKey); // verify the sig. using the issuer's public key
}