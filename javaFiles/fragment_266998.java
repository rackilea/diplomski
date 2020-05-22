import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

class Test {

    static void My_Get_Key() throws Exception {
        byte[] sk = Files.readAllBytes(Paths.get("/home/mandar/Desktop/key.txt"));
        SecretKey OriginalKey = new SecretKeySpec(sk, 0, sk.length, "AES");
        System.out.println("Decrypt Key is " + Arrays.toString(OriginalKey.getEncoded()));
    }

    static void My_Key_Generate() throws Exception {
        KeyGenerator key = KeyGenerator.getInstance("AES");
        key.init(128);
        SecretKey sk = key.generateKey();
        System.out.println("Encrypt Key is " + Arrays.toString(sk.getEncoded()));
        Files.write(Paths.get("/home/mandar/Desktop/key.txt"), sk.getEncoded());
    }

    public static void main(String[] args) throws Exception {
        My_Key_Generate();
        My_Get_Key();
    }

}