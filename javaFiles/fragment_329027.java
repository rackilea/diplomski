bytesToSign := []byte (stringToSign)
block, err8 := pem.Decode([]byte(privateKeyPem)) //-----BEGIN RSA PRIVATE KEY----
if err8 != nil {
    logger.Debugf("Error trying decode endorser private key")
}
key, _ := x509.ParsePKCS1PrivateKey(block.Bytes)
h := sha256.New()
h.Write(bytesToSign)
d := h.Sum(nil)
signature, err = rsa.SignPKCS1v15(rand.Reader, key, crypto.SHA256, d)
if err != nil {
    panic(err)
}
signatureString = base64.StdEncoding.EncodeToString(signature)