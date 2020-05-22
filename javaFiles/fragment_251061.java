import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ColorFrame extends JFrame implements ActionListener {

    private JPanel colorPanel;
    private JPanel buttonPanel;

    private JLabel color;

    private JTextField redField;
    private JTextField greenField;
    private JTextField blueField;

    private JButton preview;

    private int redInt;
    private int blueInt;
    private int greenInt;

    private ColorPanel cPanel = new ColorPanel();

    public ColorFrame(int x, int y) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonPanel = new JPanel();
        JPanel preferredSizeWrapper = new JPanel(new GridBagLayout());
        preferredSizeWrapper.add(cPanel);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        preview = new JButton("Preview Color");
        preview.addActionListener(new ButtonListener());
        buttonPanel.add(preview);
        createColorPanel();
        this.add(preferredSizeWrapper);
        this.pack();
        this.setLocation(x, y);
        this.setVisible(true);

    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // in the gui, there are three jtextfieilds that represent color
            // values. the first is red, the second is green, and the last is
            // blue.
            redInt = Integer.parseInt(redField.getText());
            greenInt = Integer.parseInt(greenField.getText());
            blueInt = Integer.parseInt(blueField.getText());
            // new ColorIcon(redInt, greenInt, blueInt)
            cPanel.setColor(new Color(redInt, greenInt, blueInt));
        }
    }

    private class ColorPanel extends JPanel {
        private Color color = Color.BLUE;

        public void setColor(Color color) {
            this.color = color;
            repaint();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        public Dimension getPreferredSize() {
            return new Dimension(150, 150);
        }
    }

    private void createColorPanel() {
        colorPanel = new JPanel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        // creates the three textfields to input rgb values.
        // the first is r, second, b third g
        redField = new JTextField(2);
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(10, 0, 0, 10);
        colorPanel.add(redField, c);

        greenField = new JTextField(2);
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.0;
        c.gridx = 1;
        c.gridy = 1;
        colorPanel.add(greenField, c);

        blueField = new JTextField(2);
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        colorPanel.add(blueField, c);

        redField.addActionListener(this);
        greenField.addActionListener(this);
        blueField.addActionListener(this);

        this.add(colorPanel, BorderLayout.EAST);
    }

    public void actionPerformed(ActionEvent arg0) {
        redInt = Integer.parseInt(redField.getText());
        greenInt = Integer.parseInt(greenField.getText());
        blueInt = Integer.parseInt(blueField.getText());

        colorPanel.add(color);

    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ColorFrame frame = new ColorFrame(200, 200);
            }
        });
    }
}