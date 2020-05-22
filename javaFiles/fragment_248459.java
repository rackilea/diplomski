package com.mysite.javaapplication;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class JavaApplication {

    private static void playSoundBytes(byte[] data) throws Exception {
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new ByteArrayInputStream(data));
        AudioFormat format = inputStream.getFormat();
        Clip clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.setFramePosition(0);
        clip.start();
    }

    private static byte[] getResourceAsBytes(String name, int bufferSize) throws IOException {
        InputStream stream = JavaApplication.class.getResourceAsStream(name);
        byte buffer[] = new byte[bufferSize];
        int b, i = 0;
        while ((b = stream.read()) != -1) {
            try {
                buffer[i++] = (byte) b;
            } catch (IndexOutOfBoundsException e) {
                throw new IOException("Buffer of " + bufferSize + " bytes is too small to read resource \"" + name + "\"");
            }
        }
        byte data[] = new byte[i + 1];
        while (i >= 0) {
            data[i] = buffer[i];
            i--;
        }
        return data;
    }

    public static void main(String[] args) throws Exception {

        byte[] soundData = getResourceAsBytes("/1.wav", 1000*1000);
        playSoundBytes(soundData);
        Thread.sleep(1000);
        playSoundBytes(soundData);
        Thread.sleep(2000);
    }
}