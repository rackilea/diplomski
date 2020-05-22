import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class MigLay extends JFrame {

    private MigLay() {
        super("Button Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new MigLayout("wrap", //Layout Constraints
        "grow, fill", //Column Constraints
        "grow, fill")); //Row Constraints
        createPanels();
        pack();
        setMinimumSize(getSize()); //Sets minimum size to the preferred size. Remove or change this line if you do not want that to happen
        setVisible(true);
    }

    private void createPanels() {

        JPanel locationPanel = new JPanel();
        JPanel usagePanel = new JPanel();
        JPanel structuralAspectsPanel = new JPanel();

        //JLabels for font metrics
        JLabel one = new JLabel("This is the first of all labels");
        JLabel two = new JLabel("Second Label");
        JLabel three = new JLabel("This Label is fairly large and long and pushes the text around");
        JLabel four = new JLabel("A label in the usage panel");
        JLabel five = new JLabel("And another one and another one and another one");

        //Font Metrics
        FontMetrics metrics = three.getFontMetrics(three.getFont()); //Take longest label manually or dynamically (You will have to add that code)
        int width = metrics.stringWidth(three.getText());

        locationPanel.setLayout(new MigLayout("gap rel 2", "[:" + width + ", grow, center][grow, left]"));
        locationPanel.setBorder(BorderFactory.createTitledBorder("Location"));

        usagePanel.setLayout(new MigLayout("gap rel 2", "[:" + width + ", grow, center][grow, left]"));
        usagePanel.setBorder(BorderFactory.createTitledBorder("Usage"));

        locationPanel.add(one);
        locationPanel.add(new JCheckBox("Checkbox with Label"), "wrap");
        locationPanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        locationPanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        locationPanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        locationPanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        locationPanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        locationPanel.add(new JSeparator(), "growx, span");
        locationPanel.add(two);
        locationPanel.add(new JCheckBox("Checkbox with Label"), "wrap");
        locationPanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        locationPanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        locationPanel.add(new JSeparator(), "growx, span");
        locationPanel.add(three);
        locationPanel.add(new JCheckBox("Checkbox with Label"), "wrap");
        locationPanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        locationPanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");

        usagePanel.add(four);
        usagePanel.add(new JCheckBox("Checkbox with Label"), "wrap");
        usagePanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        usagePanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        usagePanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        usagePanel.add(new JSeparator(), "growx, span");
        usagePanel.add(five);
        usagePanel.add(new JCheckBox("Checkbox with Label"), "wrap");
        usagePanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        usagePanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        usagePanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        usagePanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        usagePanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
        usagePanel.add(new JCheckBox("Checkbox with Label"), "skip, wrap");

        getContentPane().add(locationPanel);
        getContentPane().add(usagePanel);
    }

    public static void main(String[] args) {
        new MigLay();
    }
}