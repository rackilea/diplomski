import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TestConfig {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestConfig();
            }
        });
    }

    JFrame go = new JFrame("firstClass");
    JPanel panel = new JPanel();
    JTextArea textArea = new JTextArea();
    JButton savechanges = new JButton("Save");

    public TestConfig() {
        panel.add(textArea);
        panel.add(savechanges);

        savechanges.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    ConfigurationManager.INSTANCE.put("prop1", textArea.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(panel, "Failed to write properties", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        go.add(panel);
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setSize(750, 750);
        go.setVisible(true);

    }

    public enum ConfigurationManager {

        INSTANCE;

        protected Properties readProperties() throws IOException {
            Properties p = new Properties();
            try (FileInputStream fis = new FileInputStream("config.properties")) {
                p.load(fis);
            }
            return p;
        }

        public String get(String name) throws IOException {
            return readProperties().getProperty(name);
        }

        public void put(String key, String vaue) throws IOException {            
            Properties p =  readProperties();
            p.put(key, vaue);
            writeProperties(p);            
        }

        protected void writeProperties(Properties p) throws IOException {
            try (FileOutputStream fos = new FileOutputStream("config.properties")) {
                p.store(fos, "Config");
            }
        }            
    }
}