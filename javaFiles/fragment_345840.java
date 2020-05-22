import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Created by Niknea on 6/28/14.
 */
public class CharacterSelector {

    JPanel cselectorText;
    JFrame cselectorButtons;
    JLabel logo, characterName, label;
    JButton previous, next;

    public CharacterSelector() {
        createCharacterSelector();
    }

    public void createCharacterSelector() {

        try {
            label = new JLabel(new ImageIcon(ImageIO.read(getClass()
                    .getResource("/resources/Grass_Background.jpg"))));
            cselectorButtons = new JFrame();
            logo = new JLabel("SoccerKidz [REPLACE W/ COOL LOGO]");
            characterName = new JLabel("<Character Name>");
            logo.setPreferredSize(new Dimension(50, 50));
            logo.setFont(new Font(logo.getFont().getName(),
                    Font.HANGING_BASELINE, 50));
            characterName.setFont(new Font(characterName.getFont().getName(),
                    Font.HANGING_BASELINE, 50));
            cselectorButtons.add(logo);
            cselectorButtons.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            cselectorButtons.setContentPane(label);
            cselectorButtons.setLayout(new BorderLayout());
            characterName.setForeground(Color.CYAN);
            characterName.setHorizontalAlignment(JLabel.CENTER);
            cselectorButtons.add(characterName);
            logo.setForeground(Color.CYAN);
            logo.setHorizontalAlignment(JLabel.LEFT);
            cselectorButtons.add(logo, BorderLayout.NORTH);
            cselectorButtons.pack();
            cselectorButtons.setLocationRelativeTo(null);
            cselectorButtons.setVisible(true);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new CharacterSelector();
            }
        });
    }
}