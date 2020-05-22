import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.net.URL;
import java.text.NumberFormat;

class ImagePanelDemo {
    static class ImagePanel extends JPanel {
        private Image image;
        private Point point;

        ImagePanel(Image image, Point point) {
            this.image = image;
            this.point = point;
        }

        public void setPoint(Point point) {
            this.point = point;
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            if (image != null)
                return new Dimension(image.getWidth(this), 
                        image.getHeight(this));
            return super.getPreferredSize();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (image != null)
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            if (point != null)
                g.fillOval(point.x, point.y, 5, 5);
        }
    }

    private static void createAndShowUI() {
        try {
            JFrame frame = new JFrame("Image");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            Image image = ImageIO.read(new URL(
                "https://duke.kenai.com/comfyChair/ComfyChairRadSmall.jpg"));           

            final ImagePanel imagePanel = new ImagePanel(image, 
                    new Point(10, 10));

            frame.add(imagePanel);

            JPanel buttonPanel = new JPanel();

            final JFormattedTextField xField = new JFormattedTextField(
                    NumberFormat.getNumberInstance());
            xField.setColumns(5);
            final JFormattedTextField yField = new JFormattedTextField(
                    NumberFormat.getNumberInstance());
            yField.setColumns(5);

            JButton updateButton = new JButton("Update");

            buttonPanel.add(new JLabel("x:"));
            buttonPanel.add(xField);
            buttonPanel.add(new JLabel("y:"));
            buttonPanel.add(yField);
            buttonPanel.add(updateButton);

            updateButton.addMouseListener(new MouseAdapter() 
            {
                public void mouseClicked(MouseEvent e) {
                    try {
                    imagePanel.setPoint(new Point(
                            Integer.parseInt(xField.getText()), 
                            Integer.parseInt(yField.getText())));
                    } catch(NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.pack();
            frame.setVisible(true);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}