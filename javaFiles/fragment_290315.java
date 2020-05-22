import java.nio.ByteBuffer;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;


public class Solution1 {
    public static void main(String[] args) {
        String uuid_str = "YjRmYTJhMGEtYjI0ZC00ZjU4LTg2ZDktNTNiN2I2ODM4YjY3IzU1YjFjNGUzZTRiMGQ4OTUxMGM2YWEyNw";
        String uuid_as_64 = uuidFromBase64(uuid_str);
        System.out.println("as base64: "+uuid_as_64);
        System.out.println("as uuid: "+uuidFromBase64(uuid_as_64));
    }

    private static String uuidToBase64(String str) {
        Base64 base64 = new Base64();
        UUID uuid = UUID.fromString(str);
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return base64.encodeBase64URLSafeString(bb.array());
    }
    private static String uuidFromBase64(String str) {
        Base64 base64 = new Base64(); 
        byte[] bytes = base64.decodeBase64(str);
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        UUID uuid = new UUID(bb.getLong(), bb.getLong());
        return uuid.toString();
    }
}