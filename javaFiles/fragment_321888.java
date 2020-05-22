import javax.swing.*;
import java.awt.FlowLayout;

public class BmrCalcv2 extends JFrame {
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JLabel img1;

    public BmrCalcv2() {
        super("BMR/TDEE Calculator");
        setLayout(new FlowLayout());

        ageLabel = new JLabel("Age:");
        genderLabel = new JLabel("Gender:");
        img1 = new JLabel(new ImageIcon("filesrc/Bodybuilding-icon.png"));

        add(ageLabel);
        add(genderLabel);
        add(img1);
    }
}