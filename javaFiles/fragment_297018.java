import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public byte[] hmacMD5(byte[] key, byte[] data) {
    Mac mac = Mac.getInstance("HmacMD5");
    mac.init(new SecretKeySpec(key, "HmacMD5"));
    mac.update(data);
    return mac.doFinal();
}