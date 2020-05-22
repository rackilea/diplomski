import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderAndBox extends JFrame
{
public static void main(String args[])
{
    BorderAndBox bnb = new BorderAndBox();
    bnb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    bnb.createUI();
    bnb.setVisible(true);
}

public void createUI()
{
    JPanel borderPanel = new JPanel(new BorderLayout());

    JLabel northLabel = new JLabel("Nawth");
    borderPanel.add(northLabel, BorderLayout.NORTH);

    String[] southComboChoices = { "one", "two", "three" };
    JComboBox southCombo = new JComboBox(southComboChoices);
    borderPanel.add(southCombo, BorderLayout.SOUTH);

    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
    String[] firstChoices = { "first", "uno", "UN" };
    String[] secondChoices = { "second", "dos", "zwei" };
    String[] thirdChoices = { "third", "tres", "drei" };
    JComboBox firstCombo = new JComboBox(firstChoices);
    JComboBox secondCombo = new JComboBox(secondChoices);
    JComboBox thirdCombo = new JComboBox(thirdChoices);
    centerPanel.add(firstCombo);
    centerPanel.add(secondCombo);
    centerPanel.add(thirdCombo);
    centerPanel.add(Box.createVerticalGlue());  // first attempt; does NOT
    // take up available vertical space, instead it appears to create a space
    // that is shared equally among the (now) four components of this space.
    JPanel centerPanelConstrain = new JPanel(new GridBagLayout());
    centerPanelConstrain.add(centerPanel);
    borderPanel.add(centerPanelConstrain, BorderLayout.CENTER);

    getContentPane().add(borderPanel);
    pack();
}

}