import java.awt.*;

public class Word {

    private final String text;
    private final float confidence;
    private final Rectangle rect;

    public Word(String text, float confidence, Rectangle boundingBox) {
        this.text = text;
        this.confidence = confidence;
        this.rect = boundingBox;
    }

    public String getText() {
        return text;
    }

    public float getConfidence() {
        return confidence;
    }

    public Rectangle getBoundingBox() {
        return rect;
    }

    @Override
    public String toString() {
        return String.format("%s [Confidence: %f Bounding box: %d %d %d %d]", text, confidence, rect.x, rect.y, rect.width, rect.height);
    }
}