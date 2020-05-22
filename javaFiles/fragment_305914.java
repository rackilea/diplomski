import java.io.StringWriter;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.SecureRandom;

import org.bouncycastle.openssl.PEMWriter;

public class JSCH {

  public static void main(String[] args) throws Exception {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(2048, new SecureRandom());
    PrivateKey privateKey = keyPairGenerator.genKeyPair().getPrivate();

    StringWriter writer = new StringWriter();

    try (PEMWriter pemWriter = new PEMWriter(writer)) {
      pemWriter.writeObject(privateKey);
    }

    String privateKeyStr = writer.toString();
    System.out.println(privateKeyStr);
    com.jcraft.jsch.KeyPair
        .load(null, privateKeyStr.getBytes("US-ASCII"), null);
  }
}