import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.SignatureException;
import java.util.Date;

import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPKeyPair;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPKeyPair;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyEncryptorBuilder;

public class FileEncDec {

    private static File publicKeyFile = new File("resource/PGP1D0.pkr");
    private static File privateKeyFile = new File("resource/PGP1D0.skr");
    private static String privateKeyPassword = "passphrase";
    private static String identity = "tommybee";
    private static boolean isAll = true;

    private static void exportKeyPair(OutputStream secretOut, OutputStream publicOut, KeyPair pair, String identity,
            char[] passPhrase, boolean armor)
            throws IOException, InvalidKeyException, NoSuchProviderException, SignatureException, PGPException {
        if (armor) {
            secretOut = new ArmoredOutputStream(secretOut);
        }

        PGPDigestCalculator sha1Calc = new JcaPGPDigestCalculatorProviderBuilder().build().get(HashAlgorithmTags.SHA1);
        PGPKeyPair keyPair = new JcaPGPKeyPair(PGPPublicKey.RSA_GENERAL, pair, new Date());
        PGPSecretKey secretKey = new PGPSecretKey(PGPSignature.DEFAULT_CERTIFICATION, keyPair, identity, sha1Calc, null,
                null, new JcaPGPContentSignerBuilder(keyPair.getPublicKey().getAlgorithm(), HashAlgorithmTags.SHA1),
                new JcePBESecretKeyEncryptorBuilder(PGPEncryptedData.CAST5, sha1Calc).setProvider("BC")
                        .build(passPhrase));

        secretKey.encode(secretOut);

        secretOut.close();

        if (armor) {
            publicOut = new ArmoredOutputStream(publicOut);
        }

        PGPPublicKey key = secretKey.getPublicKey();

        key.encode(publicOut);

        publicOut.close();
    }

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", "BC");

        kpg.initialize(1024);

        KeyPair kp = kpg.generateKeyPair();

        if (isAll) {

            FileOutputStream out1 = new FileOutputStream(privateKeyFile);
            FileOutputStream out2 = new FileOutputStream(publicKeyFile);

            exportKeyPair(out1, out2, kp, identity, privateKeyPassword.toCharArray(), true);
        } else {
            FileOutputStream out1 = new FileOutputStream(privateKeyFile);
            FileOutputStream out2 = new FileOutputStream(publicKeyFile);

            exportKeyPair(out1, out2, kp, identity, privateKeyPassword.toCharArray(), false);
        }
    }

}