package ch.beo.streaming.swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

    /**
     * Helper class to convert UI components to JPEG images.
     */
    public final class JpegHelper {
        private JpegHelper() {
    }

    /**
     * Transforms any given UI {@link java.awt.Component Component} to a JPEG
     * image.
     * 
     * @param component
     *            A paintable {@link java.awt.Component Component}.
     * @return The binary representation of JPEG image, representing
     *         <code>component's</code> current visual state.
     */
    public static byte[] componentToJpeg(Component component) {
        Dimension size = component.getSize();
        BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2d = image.createGraphics();
        component.paint(graphics2d);
        graphics2d.dispose();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return out.toByteArray();
    }
}