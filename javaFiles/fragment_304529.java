import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.net.*;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class LabelFrame extends JFrame {
    private static final int ROWS = 30;
    private static final int COLS = 80;
    private final JTextField urlString;
    private final JButton loadButton;
    String content;
    JTextArea textArea = new JTextArea(ROWS, COLS);

    public LabelFrame() {
        super("WebStalker");
        // setSize(600, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLayout(new FlowLayout()); // !! no
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setBackground(UIManager.getColor("Label.background"));
        textArea.setFont(UIManager.getFont("Label.font"));
        textArea.setBorder(UIManager.getBorder("Label.border"));

        urlString = new JTextField("https:Search", 30);
        loadButton = new JButton("Load");

        JPanel panel = new JPanel();
        JLabel label = new JLabel("URL");
        panel.add(label);
        panel.add(urlString);
        panel.add(loadButton);

        JScrollPane jp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // panel.add(jp);
        this.add(panel, BorderLayout.PAGE_START);
        add(jp);

        pack(); // JFrame στο ελάχιστο μέγεθος με όλα τα περιεχόμενα
        setLocationRelativeTo(null); // τοποθετεί στο κέντρο το παράθυρο

        TextFieldHandler tHandler = new TextFieldHandler();
        ButtonHandler bHandler = new ButtonHandler();

        urlString.addActionListener(tHandler);
        loadButton.addActionListener(bHandler);

        urlString.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                urlString.setText("");
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LabelFrame().setVisible(true);
        });
    }

    private class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                content = URLReaderFinal.Reading(event.getActionCommand());

                textArea.setText(content);

                // !! getContentPane().add(textArea, BorderLayout.CENTER);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "This url doesnt exist", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                content = URLReaderFinal.Reading(urlString.getText());
                textArea.setText(content);

                // getContentPane().add(textArea, BorderLayout.CENTER);
            } catch (Exception e) {
                System.out.println("Unable to load page");
                JOptionPane.showMessageDialog(null, "Unable to load page", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}