package com.stackexchange.so;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class LineStreamRC4 {

    private SecretKey rc4Key;

    public LineStreamRC4(SecretKey rc4Key) {
        this.rc4Key = rc4Key;

    }

    public void encryptLineByLine(File in, File out) throws Exception {
        Cipher c = Cipher.getInstance("RC4");
        c.init(Cipher.ENCRYPT_MODE, rc4Key);

        try (BufferedReader reader = new BufferedReader(
                new FileReader(in, UTF_8));
                CipherOutputStream cryptWriter = new CipherOutputStream(
                        new FileOutputStream(out), c)) {

            String line;
            while ((line = reader.readLine()) != null) {
                line += String.format("%n");
                cryptWriter.write(line.getBytes(UTF_8));
            }
        }
    }

    public void decryptLineByLine(File in, File out) throws Exception {
        Cipher c = Cipher.getInstance("RC4");
        c.init(Cipher.DECRYPT_MODE, rc4Key);

        try (BufferedReader cryptReader = new BufferedReader(
                new InputStreamReader(
                        new CipherInputStream(new FileInputStream(in), c), UTF_8));
                FileWriter writer = new FileWriter(out, UTF_8)) {

            String line;
            while ((line = cryptReader.readLine()) != null) {
                line += String.format("%n");
                writer.write(line);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        File pt = new File("src/com/stackexchange/so/LineStreamRC4.java");
        File ct = new File("bla.ct");
        LineStreamRC4 rc4LineStream = new LineStreamRC4(new SecretKeySpec(new byte[16], "RC4"));
        rc4LineStream.encryptLineByLine(pt, ct);
        File pt2 = new File("bla.pt");
        rc4LineStream.decryptLineByLine(ct, pt2);
    }
}