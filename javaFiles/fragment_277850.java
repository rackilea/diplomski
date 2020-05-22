import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PokemonJournal {
    private JFrame frame;
    private JPanel pane;
    private GridBagConstraints gbc;
    private JLabel imageLabel;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel level;
    private JLabel gender;
    private JLabel pokemonCaught;
    private JLabel raidWon;
    private JLabel pokestopVisited;
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField levelField;
    private JTextField genderField;
    private JButton pokemonCaughtButton;
    private JButton raidWonButton;
    private JButton pokestopVisitedButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new PokemonJournal()::createAndShowGui);
    }

    private void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());
        pane = new JPanel();
        pane.setLayout(new GridBagLayout());

        gbc = new GridBagConstraints();

        imageLabel = new JLabel();
        try {
            imageLabel.setIcon(new ImageIcon(
                    new URL("http://pm1.narvii.com/6535/1b362404d09091a335ce53fa68506827418890a3_128.jpg")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        firstName = new JLabel("First Name: ");
        lastName = new JLabel("Last Name: ");
        level = new JLabel("Level: ");
        gender = new JLabel("Gender: ");
        pokemonCaught = new JLabel("Pokemon Caught: ");
        raidWon = new JLabel("Raid Won: ");
        pokestopVisited = new JLabel("Pokestop Visited: ");

        nameField = new JTextField(10);
        lastNameField = new JTextField(10);
        levelField = new JTextField(10);
        genderField = new JTextField(10);

        pokemonCaughtButton = new JButton("Show");
        raidWonButton = new JButton("Show");
        pokestopVisitedButton = new JButton("Show");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        pane.add(imageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridheight = 1;
        pane.add(firstName, gbc);

        gbc.gridx = 2;
        pane.add(nameField, gbc);

        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy++;
        pane.add(lastName, gbc);

        gbc.gridx = 2;
        pane.add(lastNameField, gbc);

        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy++;
        pane.add(level, gbc);

        gbc.gridx = 2;
        pane.add(levelField, gbc);

        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy++;
        pane.add(gender, gbc);

        gbc.gridx = 2;
        pane.add(genderField, gbc);

        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy++;
        pane.add(pokemonCaught, gbc);

        gbc.gridx = 2;
        pane.add(pokemonCaughtButton, gbc);

        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy++;
        pane.add(raidWon, gbc);

        gbc.gridx = 2;
        pane.add(raidWonButton, gbc);

        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy++;
        pane.add(pokestopVisited, gbc);

        gbc.gridx = 2;
        pane.add(pokestopVisitedButton, gbc);

        frame.add(pane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}