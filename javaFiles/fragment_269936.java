import java.awt.*;
import javax.swing.*;

public class GridBagDemo implements Runnable
{
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new GridBagDemo());
  }

  public void run()
  {
    JComponent redComp = new JPanel();
    redComp.setBackground(Color.RED);

    JComponent greenComp = new JPanel();
    greenComp.setBackground(Color.GREEN);

    JComponent blueComp = new JPanel();
    blueComp.setBackground(Color.BLUE);

    JComponent whiteComp = new JPanel();
    whiteComp.setBackground(Color.WHITE);

    GridBagConstraints gbc = new GridBagConstraints();
    // we'll use this anchor/fill for all components
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.fill = GridBagConstraints.BOTH;

    JPanel panel = new JPanel(new GridBagLayout());

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.gridheight = 1;
    gbc.weightx = 0.8;  // use 80% of the overall width
    gbc.weighty = 0.8;  // use 80% of the overall height
    panel.add(redComp, gbc);

    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 2;
    gbc.weightx = 0.2;  // use 20% of the overall width
    gbc.weighty = 1.0;  // use 100% of the overall height
    panel.add(blueComp, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.weightx = 0.8;  // use 80% of the width used by green/white comps
    gbc.weighty = 0.2;  // use 20% of the overall height
    panel.add(greenComp, gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.weightx = 0.2;  // use 20% of the width used by green/white comps
    gbc.weighty = 0.2;  // use 20% of the overall height
    panel.add(whiteComp, gbc);

    JFrame frame = new JFrame("GrigBag Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(panel);
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}