import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ExampleLayout {

    public static void main(String[] args) {
        new ExampleLayout();
    }

    public ExampleLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private HeaderPane header;
        private ScorePane score;
        private CharacterSelectionPane characterSelection;

        public TestPane() {

            setLayout(new BorderLayout());

            JLabel background = new JLabel();

            try {
                BufferedImage img = ImageIO.read(getClass().getResource("/Grass.jpg"));
                background.setIcon(new ImageIcon(img));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            add(background);

            background.setLayout(new GridBagLayout());

            header = new HeaderPane();
            score = new ScorePane();
            characterSelection = new CharacterSelectionPane();

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.BOTH;

            background.add(header, gbc);
            background.add(score, gbc);
            gbc.weighty = 1;
            background.add(characterSelection, gbc);
        }
    }

    public class HeaderPane extends JPanel {

        public HeaderPane() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel("Character Selection");
            label.setForeground(Color.WHITE);
            label.setFont(label.getFont().deriveFont(Font.BOLD, 48f));
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label);
            setOpaque(false);
        }

    }

    public class ScorePane extends JPanel {

        public ScorePane() {
            JLabel label = new JLabel("[-][-[]-][-]");
            label.setForeground(Color.YELLOW);
            add(label);
            setOpaque(false);
        }

    }

    public class CharacterSelectionPane extends JPanel {

        private JButton btMale;
        private JButton btFemale;
        private JTextField tfName;
        private JButton btContinue;

        public CharacterSelectionPane() {
            setOpaque(false);
            setLayout(new GridBagLayout());

            btMale = new JButton("Male");
            btFemale = new JButton("Female");
            btContinue = new JButton("Continue");
            tfName = new JTextField(10);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(btMale, gbc);
            gbc.gridx++;
            add(btFemale, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Name:"), gbc);
            gbc.gridx++;
            add(tfName, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(btContinue, gbc);
        }

    }

}