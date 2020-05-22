//nopackage
import java.security.*;
import java.util.Base64;

public class SO43459993SimpleRSAPEM {
    public static void main (String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048); KeyPair kp = kpg.generateKeyPair();

        System.out.println ("-----BEGIN PRIVATE KEY-----");
        System.out.println (Base64.getMimeEncoder().encodeToString( kp.getPrivate().getEncoded()));
        System.out.println ("-----END PRIVATE KEY-----");
        System.out.println ("-----BEGIN PUBLIC KEY-----");
        System.out.println (Base64.getMimeEncoder().encodeToString( kp.getPublic().getEncoded()));
        System.out.println ("-----END PUBLIC KEY-----");

    }
}