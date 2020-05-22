import java.text.Normalizer;

try {
    return Normalizer.normalize(word, Normalizer.Form.NFC);
} catch (Exception ex) {
    return null;
}