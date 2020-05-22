import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;

public class VectorizedImage {
    private final BufferedImage img;

    public VectorizedImage(BufferedImage img) {
        this.img = img;
    }

    public void draw(Graphics2D g) {
        Color oldC = g.getColor();
        Composite oldCo = g.getComposite();
        AlphaComposite comp = AlphaComposite.SrcOver;
        double lap = 1/Math.sqrt(g.getTransform().getDeterminant()); // This deals with inter-pixel borders letting the background shine through
        Path2D pixel = new Path2D.Double();
        pixel.moveTo(0, 0);
        pixel.lineTo(0, 1);
        pixel.lineTo(1, 1);
        pixel.lineTo(1, 0);
        pixel.lineTo(0, 0);
        pixel.transform(AffineTransform.getScaleInstance(1+lap, 1+lap));
        for (int i = 0; i < img.getWidth(); i++)
            for (int j = 0; j < img.getHeight(); j++) {
                g.setColor(new Color(img.getRGB(i, j)));
                g.setComposite(comp.derive(img.getAlphaRaster().getSampleFloat(i, j, 0) / 255));
                g.fill(pixel.createTransformedShape(AffineTransform.getTranslateInstance(i, j)));
        }
        g.setColor(oldC);
        g.setComposite(oldCo);
    }
}