import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TheLifeOfErnestRhodes extends JFrame {

    private static JFrame frame = new JFrame("The Life of Ernest Rhodes");

    private static Color black = new Color(40, 40, 40);
    private static Color gold = new Color(255, 223, 0);
    private static Color sienna = new Color(255, 82, 45);
    private static Color stone = new Color(119, 136, 153);

    private static Font titleFont = new Font("Serif", Font.BOLD + Font.ITALIC, 48);
    private static Font textFont = new Font("Serif", Font.PLAIN, 20);
    private static Font buttonFont = new Font("Serif", Font.BOLD + Font.ITALIC, 20);

    private void setFrame() {

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setResizable(false);

        Container pane = frame.getContentPane();
        JPanel backPanel = new JPanel();
        backPanel.setBackground(black);
        backPanel.setVisible(true);
        pane.add(backPanel);
        pane.add(charScreen());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TheLifeOfErnestRhodes().setFrame();
            }
        });
    }

    private JPanel charScreen() {

        GridBagLayout layout = new GridBagLayout();
        JPanel charScreen = new JPanel(layout);

        charScreen.setBackground(black);
        charScreen.setVisible(true);

        //Static labels for the two headings/titles on this screen.
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(80, 0, 20, 0);

        JLabel heading = new JLabel("THE LIFE OF ERNEST RHODES");
        heading.setForeground(gold);
        heading.setFont(titleFont);
        charScreen.add(heading, c);

        c.gridy++;
        c.anchor = GridBagConstraints.BASELINE;
        c.insets = new Insets(0, 0, 10, 0);

        JLabel title = new JLabel("CHARACTER CREATION");
        title.setForeground(stone);
        title.setFont(titleFont);
        charScreen.add(title, c);

        c.gridy++;
        c.insets = new Insets(10, 20, 10, 20);

//        JPanel namePanel = new JPanel(new FlowLayout());

        charScreen.add(new NamePane(), c);

        c.gridx = 0;
        c.gridy++;
        c.fill = GridBagConstraints.NONE;

        JLabel availablePts = new JLabel("AVAILABLE POINTS: 5");
        availablePts.setForeground(stone);
        availablePts.setFont(textFont);
        availablePts.setVisible(true);
        charScreen.add(availablePts, c);

        c.gridx++;

        JLabel allocatedPts = new JLabel("ALLOCATED POINTS:");
        allocatedPts.setForeground(stone);
        allocatedPts.setFont(textFont);
        allocatedPts.setVisible(true);
        charScreen.add(allocatedPts, c);

        c.gridx++;

        JLabel selectTrait = new JLabel("SELECT TRAITS:");
        selectTrait.setForeground(stone);
        selectTrait.setFont(textFont);
        selectTrait.setVisible(true);
        charScreen.add(selectTrait, c);

        c.gridx = 0;
        c.gridy++;

        JLabel labelInv = new JLabel("Investigation");
        labelInv.setForeground(gold);
        labelInv.setFont(textFont);
        labelInv.setVisible(true);
        charScreen.add(labelInv, c);

        c.gridy++;

        JLabel labelPers = new JLabel("Persuasion");
        labelPers.setForeground(gold);
        labelPers.setFont(textFont);
        labelPers.setVisible(true);
        charScreen.add(labelPers, c);

        c.gridy++;

        JLabel LabelStl = new JLabel("Stealth");
        LabelStl.setForeground(gold);
        LabelStl.setFont(textFont);
        LabelStl.setVisible(true);
        charScreen.add(LabelStl, c);

        c.gridx++;
        c.gridy = 4;

        JLabel allocatedInt = new JLabel("0");
        allocatedInt.setForeground(stone);
        allocatedInt.setFont(textFont);
        allocatedInt.setVisible(true);
        charScreen.add(allocatedInt, c);

        c.gridy++;

        JLabel allocatedPers = new JLabel("0");
        allocatedPers.setForeground(stone);
        allocatedPers.setFont(textFont);
        allocatedPers.setVisible(true);
        charScreen.add(allocatedPers, c);

        c.gridy++;

        JLabel allocatedAth = new JLabel("0");
        allocatedAth.setForeground(stone);
        allocatedAth.setFont(textFont);
        allocatedAth.setVisible(true);
        charScreen.add(allocatedAth, c);

        c.gridx++;
        c.gridy = 4;

        JLabel keenEye = new JLabel("Keen Eye");
        keenEye.setForeground(sienna);
        keenEye.setFont(textFont);
        keenEye.setVisible(true);
        charScreen.add(keenEye, c);

        c.gridy++;

        JLabel interrogator = new JLabel("Interrogator");
        interrogator.setForeground(gold);
        interrogator.setFont(textFont);
        interrogator.setVisible(true);
        charScreen.add(interrogator, c);

        c.gridy++;

        JLabel sleuth = new JLabel("Sleuth");
        sleuth.setForeground(gold);
        sleuth.setFont(textFont);
        sleuth.setVisible(true);
        charScreen.add(sleuth, c);

        c.gridx = 1;
        c.gridy++;

        JLabel reset = new JLabel("Reset Stats");
        reset.setForeground(gold);
        reset.setFont(textFont);
        reset.setVisible(true);
        charScreen.add(reset, c);

        c.gridy++;

        JLabel gender = new JLabel("GENDER:");
        gender.setForeground(stone);
        gender.setFont(textFont);
        gender.setVisible(true);
        charScreen.add(gender, c);

        c.gridx = 0;
        c.gridy++;

        JLabel male = new JLabel("Male");
        male.setForeground(gold);
        male.setFont(textFont);
        male.setVisible(true);
        charScreen.add(male, c);

        c.gridx++;

        JLabel female = new JLabel("Female");
        female.setForeground(gold);
        female.setFont(textFont);
        female.setVisible(true);
        charScreen.add(female, c);

        c.gridx++;

        JLabel other = new JLabel("Other");
        other.setForeground(sienna);
        other.setFont(textFont);
        other.setVisible(true);
        charScreen.add(other, c);

        c.gridx = 1;
        c.gridy++;
        c.anchor = GridBagConstraints.PAGE_END;

        JLabel clickNext = new JLabel("Continue");
        clickNext.setForeground(stone);
        clickNext.setFont(titleFont);
        clickNext.setVisible(true);
        charScreen.add(clickNext, c);

        return charScreen;
    }

    public class NamePane extends JPanel {

        public NamePane() {
            JLabel labelName = new JLabel("FULL NAME:");
            labelName.setForeground(stone);
            labelName.setFont(textFont);
            labelName.setVisible(true);
            add(labelName);

            JTextField firstName = new JTextField("Taylor", 20);
//            firstName.setMinimumSize(firstName.getPreferredSize());
            firstName.setBackground(black.darker());
            firstName.setForeground(stone);
            firstName.setFont(textFont);
            firstName.setHorizontalAlignment(JTextField.CENTER);
            firstName.setBorder(null);
            firstName.setVisible(true);
            add(firstName);

            JTextField lastName = new JTextField("Woodhouse", 20);
//            lastName.setMinimumSize(lastName.getPreferredSize());
            lastName.setBackground(black.darker());
            lastName.setForeground(stone);
            lastName.setFont(textFont);
            lastName.setHorizontalAlignment(JTextField.CENTER);
            lastName.setBorder(null);
            lastName.setVisible(true);
            add(lastName);

            JLabel displayName = new JLabel("TYPE A NAME & PRESS 'ENTER'");
            displayName.setForeground(stone);
            displayName.setFont(textFont);
            displayName.setVisible(true);
            add(displayName);
        }

    }

}