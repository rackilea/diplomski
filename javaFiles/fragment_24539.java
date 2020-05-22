/**
 * Retrieve public key from PKCS7 certificate
 * 
 * @param certPath
 * @return
 * @throws IOException
 * @throws InvalidKeySpecException
 * @throws NoSuchAlgorithmException
 */
public static String getPublicKey(String certPath) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {

    File f = new File(certPath);
    FileInputStream is = new FileInputStream(f);

    ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    int nRead;
    byte[] data = new byte[16384];

    while ((nRead = is.read(data, 0, data.length)) != -1) {
        buffer.write(data, 0, nRead);
    }

    buffer.flush();
    PKCS7 test = new PKCS7(buffer.toByteArray());
    X509Certificate[] certs = test.getCertificates();

    for (int i = 0; i < certs.length; i++) {
        if (certs[i] != null && certs[i].getPublicKey() != null) {
            return new BASE64Encoder().encode(certs[i].getPublicKey().getEncoded());
        }
    }
    return "";
}