import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class Test {

    public static void main(String[] args) {
        new Test ();
    }

    public Test () {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new ConfigurationPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ConfigurationPane extends JPanel {

        private KeyPressPane keyPressPane;
        private JTextField name;

        public ConfigurationPane() {

            name = new JTextField(10);
            keyPressPane = new KeyPressPane();

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(name, gbc);
            add(keyPressPane, gbc);

            JButton save = new JButton("Save");
            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Properties p = new Properties();
                    p.setProperty("name", name.getText());
                    p.setProperty("keyCode", Integer.toString(keyPressPane.getKeyCode()));
                    p.setProperty("modifiers", Integer.toString(keyPressPane.getModifiers()));

                    try (OutputStream os = new FileOutputStream(new File("Config.cfg"))) {
                        p.store(os, "Key config");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            add(save);

        }

    }

    public static class KeyPressPane extends JPanel {

        protected static final Border FOCUSED_BORDER = BorderFactory.createLineBorder(UIManager.getColor("List.selectionBackground"));
        protected static final Border UNFOCUSED_BORDER = UIManager.getBorder("TextField.border");

        private JLabel label;

        private int keyCode;
        private int modifiers;
        private char key;

        public KeyPressPane() {

            setBackground(UIManager.getColor("TextField.background"));
            setLayout(new GridBagLayout());
            label = new JLabel(" ");
            label.setFont(UIManager.getFont("Label.font").deriveFont(48f));
            add(label);
            addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    keyCode = e.getKeyCode();
                    modifiers = e.getModifiers();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    char key = e.getKeyChar();
                    label.setText(Character.toString(key));
                }
            });
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    requestFocusInWindow();
                }
            });
            addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    setBorder(FOCUSED_BORDER);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    System.out.println("unfocused");
                    setBorder(UNFOCUSED_BORDER);
                }
            });
            setBorder(UNFOCUSED_BORDER);
            setFocusable(true);
        }

        public int getKeyCode() {
            return keyCode;
        }

        public int getModifiers() {
            return modifiers;
        }

    }

}