package pdfwriter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.util.Matrix;

public class SO57387803DrawShapesInPDF {

    private static class MyImagePanel extends JPanel {

        final BufferedImage image;
        //final float scale = .38f;
        final int DPI = 200;
        float scale = 72f / DPI;

        //NEW
        double affineX;
        double affineY;

        AffineTransform atg;
        Point start = new Point();
        Point end = new Point();
        boolean isNewLine = true;
        static ArrayList<Line2D> lines = new ArrayList<>();
        static PDDocument document;

        public MyImagePanel() throws IOException {
            document = PDDocument.load(new File("plan.pdf"));
            PDFRenderer renderer = new PDFRenderer(document);

            image = renderer.renderImageWithDPI(0, DPI, ImageType.RGB);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    if (end != start) {
                        Line2D line = new Line2D.Float(start.x, start.y, end.x, end.y);

                        lines.add(line);
                        Point2D p = calcCoordinates(e);

                        start = new Point();
                        start.x = (int) p.getX();
                        start.y = (int) p.getY();

                        repaint();
                    }

                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    Point2D p = calcCoordinates(e);
                    end = new Point();

                    end.x = (int) p.getX();
                    end.y = (int) p.getY();
                    repaint();
                }
            });
            addMouseWheelListener(new MouseWheelListener() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {

                    int rotation = e.getWheelRotation();

                    //Zoom in/out on CTRL
                    if (e.isControlDown()) {

                        if (rotation < 0) {
                            scale -= .05;
                        } else {
                            scale += .05;
                        }
                        if (scale < .2) {
                            scale = .2f;
                        } else if (scale > 4) {
                            scale = 4;
                        }
                        revalidate();
                        repaint();
                    }
                }
            });
        }

        private Point2D calcCoordinates(MouseEvent e) {
            Point p = new Point(e.getX(), e.getY());
            try {
                return atg.inverseTransform(p, null);
            } catch (NoninvertibleTransformException ex) {
                return p;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2D = (Graphics2D) g.create();

            //          double  affineX = (getWidth() - scale * image.getWidth()) / 2;
            //          double affineY = (getHeight() - scale * image.getHeight()) / 2;
            //          updated
            affineX = (getWidth() - scale * image.getWidth()) / 2;
            affineY = (getHeight() - scale * image.getHeight()) / 2;

            AffineTransform at = new AffineTransform();
            at.translate(affineX, affineY);
            at.scale(scale, scale);

            AffineTransform atf = g2D.getTransform();
            atf.concatenate(at);
            atg = (AffineTransform) at.clone();

            g2D.setTransform(atf);
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2D.drawImage(image, 0, 0, this);
            try {
                g2D.drawLine(start.x, start.y, end.x, end.y);
            } catch (NullPointerException e) {

            }

            for (Line2D l : lines) {
                g2D.draw(l);
            }

            g2D.dispose();
        }

        public void save() {

            try {
                PDPage page = document.getPage(0);

                PDPageContentStream contentStream = new PDPageContentStream(document, page, true, true, true);
                contentStream.transform(Matrix.getRotateInstance(Math.toRadians(270), 0, page.getMediaBox().getHeight()));
                for (Line2D l : lines) {
                    Point2D p1 = new Point((int) l.getX1(), (int) l.getY1());
                    Point2D p2 = new Point((int) l.getX2(), (int) l.getY2());

                    p1 = atg.transform(p1, null);
                    p2 = atg.transform(p2, null);

                    //UPATED
                    System.out.println("Points");
                    System.out.println(p1);
                    System.out.println(p2);
                    System.out.println("Scale " + scale);

                    //0.36 is the default scale or 72/200f 
                    contentStream.moveTo((float) (p1.getX() / (scale / .36)), (float) (page.getMediaBox().getWidth() - p1.getY() / (scale / .36)));

                    contentStream.lineTo((float) (p2.getX() / (scale / .36)), (float) (page.getMediaBox().getWidth() - p2.getY() / (scale / .36)));

                    contentStream.stroke();
                }

                contentStream.close();

                document.save(new File("c:\\users\\john ebarita\\documents\\saved.pdf"));
                document.close();
                System.out.println("file saved");
            } catch (IOException ex) {
                //                Logger.getLogger(SO57387803DrawShapesInPDF.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }

        }

        @Override
        public Dimension getPreferredSize() {
            int width = (int) (scale * image.getWidth());
            int height = (int) (scale * image.getHeight());
            return new Dimension(width, height);
        }
    }

    public static void main(String[] args) {

        //        System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
        JFrame frame = new JFrame("PDF");
        frame.setSize(1500, 1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // MyImagePanel imagePanel = null;
        MyImagePanel imagePanel;
        try {
            imagePanel = new MyImagePanel();
        } catch (IOException ex) {
            ex.printStackTrace();
            //            Logger.getLogger(SO57387803DrawShapesInPDF.class
            //                    .getName()).log(Level.SEVERE, null, ex);
            return; // or there would be an uninitialized variable
        }

        JButton btn = new JButton("Save");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imagePanel.save();
                //MyImagePanel.save();
            }
        });

        btn.setBounds(10, 0, 70, 30);

        frame.add(btn);
        JPanel pnl = new JPanel();
        pnl.add(imagePanel);
        pnl.setBounds(0, 100, 1500, 1200);
        frame.add(pnl);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

}