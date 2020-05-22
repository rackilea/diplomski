import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Example {

    public Example() {
        JTextArea textArea = new JTextArea("There is a locked door");
        textArea.setRows(5);
        textArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textArea.setEditable(false);

        WhiteButton button1 = new WhiteButton("Go find a key") {
            @Override
            public Dimension getMinimumSize() {
                return new Dimension(200, 25);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 25);
            }

            @Override
            public Dimension getMaximumSize() {
                return new Dimension(200, 25);
            }
        };
        WhiteButton button2 = new WhiteButton("Attempt to force the door open");
        button2.setMargin(new Insets(0, 60, 0, 60));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(button1);
        buttonPanel.add(Box.createVerticalStrut(5));
        buttonPanel.add(button2);

        WhiteButton inventoryButton = new WhiteButton(
                new ImageIcon(new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB)));

        JLabel locationLabel = new JLabel("Location: 0");
        locationLabel.setVerticalAlignment(JLabel.BOTTOM);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(inventoryButton, BorderLayout.WEST);
        southPanel.add(locationLabel, BorderLayout.EAST);

        JPanel mainPanel = new JPanel(new BorderLayout(0, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainPanel.add(textArea, BorderLayout.NORTH);
        mainPanel.add(buttonPanel);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

    private class WhiteButton extends JButton {

        public WhiteButton() {
            setBackground(Color.WHITE);
        }

        public WhiteButton(String text) {
            this();
            setText(text);
        }

        public WhiteButton(ImageIcon icon) {
            this();
            setIcon(icon);
            setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }

    }

}