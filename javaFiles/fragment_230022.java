import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class HangmanGUI2 extends JPanel {
    private HangmanModel model = new HangmanModel();
    private HangmanPanel2 panel2 = new HangmanPanel2(model);
    private JSlider slider = new JSlider(0, HangmanModel.MAX_VALUE, 0);
    private JTextField textField = new JTextField(10);

    public HangmanGUI2() {
        textField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateModel(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateModel(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateModel(e);
            }

            private void updateModel(DocumentEvent e) {
                Document doc = e.getDocument();
                int length = doc.getLength();
                try {
                    String text = doc.getText(0, length);
                    int value = Integer.parseInt(text.trim());
                    setModelValue(value);
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                } catch (NumberFormatException e1) {
                    // Do Nothing
                }
            }
        });

        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(e -> {
            int value = slider.getValue();
            setModelValue(value);
        });

        setLayout(new BorderLayout());
        add(panel2);
        add(textField, BorderLayout.PAGE_START);
        add(slider, BorderLayout.PAGE_END);

//        new Timer(1000, e -> {
//            model.increment();
//            repaint();
//        }).start();  
    }

    protected void setModelValue(int value) {
        model.setValue(value);
        repaint();
    }

    private static void createAndShowGui() {
        HangmanGUI2 mainPanel = new HangmanGUI2();

        JFrame frame = new JFrame("HangmanGUI2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}