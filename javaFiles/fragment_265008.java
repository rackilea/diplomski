private static final boolean isEncrypt = false;
public static void main(String[] args) {
    Security.addProvider(new BouncyCastleProvider());

    String outFileName = "resource/tile_doc.signed.in";
    String recoverFile = "resource/tile_doc.out";
    OutputStream out = null;
    InputStream keyIn = null;
    InputStream outFileIn = null;
    String fileName = "resource/tile_doc.in";

    PGPPublicKey encKey = null;

    char[] passPhrase = privateKeyPassword.toCharArray();
    boolean armor = false;
    boolean withIntegrityCheck = true;

    if (isEncrypt) {
        try {
            keyIn = new BufferedInputStream(new FileInputStream(privateKeyFile));
            out = new BufferedOutputStream(new FileOutputStream(outFileName));
            encKey = readPublicKeyFromCol(new FileInputStream(publicKeyFile));
            //
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


            try {
                signFile(fileName, keyIn, out, passPhrase, armor);

                out = new BufferedOutputStream(new FileOutputStream(outFileName));

            } catch (GeneralSecurityException | IOException | PGPException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        encryptFile(outFileName, out, fileName, encKey, passPhrase, armor, withIntegrityCheck);
    } else {


        try {
            keyIn = new BufferedInputStream(new FileInputStream(privateKeyFile));
            outFileIn = new BufferedInputStream(new FileInputStream(outFileName));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        decryptFile(outFileIn, keyIn, passPhrase, recoverFile);
    }
}