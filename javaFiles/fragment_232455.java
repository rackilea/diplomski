import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FontTest {

    public static void main(String[] args) {
        new FontTest();
    }

    public FontTest() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            JTextField field = new JTextField("Bunch a munchy carrots");
            add(field, gbc);

            JToggleButton bold = new JToggleButton("Bold");
            JToggleButton italic = new JToggleButton("Italic");

            ActionListener listener = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Font font = field.getFont();
                    if (bold.isSelected() && italic.isSelected()) {
                        font = font.deriveFont(Font.BOLD | Font.ITALIC);
                    } else if (bold.isSelected()) {
                        font = font.deriveFont(Font.BOLD);
                    } else if (italic.isSelected()) {
                        font = font.deriveFont(Font.ITALIC);
                    } else {
                        font = font.deriveFont(Font.PLAIN);
                    }
                    field.setFont(font);
                }
            };

            bold.addActionListener(listener);
            italic.addActionListener(listener);

            add(bold);
            add(italic);
        }

    }

}