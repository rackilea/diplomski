String algorithm = "MD5withRSA";

// Initialize JCE provider    
Signature verifier = Signature.getInstance(algorithm);

// Do the verification   
boolean result=false;

try {
    verifier.initVerify(cert); // This one checks key usage in the cert
    verifier.update(data);
    result = verifier.verify(sigBytes);
}
catch (Exception e) {
    throw new VerificationException("Verification error: "+e, e);
}