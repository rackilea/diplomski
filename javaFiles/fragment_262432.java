import org.apache.commons.codec.binary.Hex;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

private String getHash(String s) throws Exception {

    Mac mac = Mac.getInstance("HMACSHA256");
    mac.init(new SecretKeySpec("Password".getBytes("UTF-8"), ""));

    byte[] ret = mac.doFinal(s.getBytes("UTF-8"));

    return Hex.encodeHexString(ret);
}