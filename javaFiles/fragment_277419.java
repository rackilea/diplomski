package de.scrum_master.so;

import com.musicg.fingerprint.FingerprintManager;
import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.fingerprint.FingerprintSimilarityComputer;
import com.musicg.wave.Wave;
import javazoom.jl.converter.Converter;
import javazoom.jl.decoder.JavaLayerException;

public class Application {
  public static void main(String[] args) throws JavaLayerException {
    // MP3 to WAV
    new Converter().convert("White Wedding.mp3", "White Wedding.wav");
    new Converter().convert("Poison.mp3", "Poison.wav");
    // Fingerprint from WAV
    byte[] firstFingerPrint = new FingerprintManager().extractFingerprint(new Wave("White Wedding.wav"));
    byte[] secondFingerPrint = new FingerprintManager().extractFingerprint(new Wave("Poison.wav"));
    // Compare fingerprints
    FingerprintSimilarity fingerprintSimilarity = new FingerprintSimilarityComputer(firstFingerPrint, secondFingerPrint).getFingerprintsSimilarity();
    System.out.println("Similarity score = " + fingerprintSimilarity.getScore());
  }
}