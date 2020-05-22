import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class LayeredPaneDemo2 extends JPanel implements ActionListener {
  private final Color[] layerColors = {
      Color.yellow, Color.magenta, Color.cyan,
      Color.red, Color.green, Color.blue };

  private final JLayeredPane layeredPane;
  private final List<JLabel> labels;

  private JButton update;

  public LayeredPaneDemo2() {
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

    labels = new ArrayList<>();
    // JLayeredPane is not much related, it is a problem of how to use GridBagLayout.
    layeredPane = new LXLayeredPane();
    layeredPane.setPreferredSize(new Dimension(400, 410));
    layeredPane.setBorder(BorderFactory.createTitledBorder(
        "Click to change colors"));

    // Add several labels to the layered pane.
    layeredPane.setLayout(new GridBagLayout());

    for (int i = 0; i < layerColors.length; i++) {
      JLabel label = createColoredLabel("Test" + i, layerColors[i]);
      labels.add(label);
      layeredPane.add(label, new StackConstraints(i, gbc(i)));
    }
//     //TEST1: Create reference grid
//     GridBagConstraints c = new GridBagConstraints(
//       0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
//       GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
//     for (int i = 0; i < layerColors.length + 1; i++) {
//       c.gridx = i;
//       c.gridy = i;
//       layeredPane.add(Box.createRigidArea(new Dimension(20, 20)), c);
//     }
    //TEST2: Create reference grid >>>
    GridBagConstraints c = new GridBagConstraints(
        6, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
    for (int i = 0; i < layerColors.length; i++) {
      c.gridx = i;
      Component box = Box.createRigidArea(new Dimension(20, 20));
      ((JComponent) box).setBorder(BorderFactory.createLineBorder(Color.RED));
      layeredPane.add(box, c);
    }
    c.gridx = 6;
    for (int i = 0; i < layerColors.length; i++) {
      c.gridy = i;
      Component box = Box.createRigidArea(new Dimension(20, 20));
      ((JComponent) box).setBorder(BorderFactory.createLineBorder(Color.RED));
      layeredPane.add(box, c);
    }
    // <<<
    // Add control pane and layered pane to this JPanel.
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(createControlPanel());
    add(Box.createRigidArea(new Dimension(0, 10)));
    add(layeredPane);
  }

  private GridBagConstraints gbc(int i) {
    return new GridBagConstraints(
        i, i, 2, 2, 0.0, 0.0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
  }

  // Create and set up a colored label.
  private JLabel createColoredLabel(String text, Color color) {
    JLabel label = new JLabel(text) {
      @Override protected void paintComponent(Graphics g) {
        g.setColor(new Color(100, 100, 100, 100));
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
      }
    };
    label.setVerticalAlignment(JLabel.TOP);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setOpaque(true);
    label.setBackground(color);
    label.setForeground(Color.black);
    label.setBorder(BorderFactory.createLineBorder(Color.black));
    label.setPreferredSize(new Dimension(240, 240));
    return label;
  }

  // Create the control pane for the top of the frame.
  private JPanel createControlPanel() {
    update = new JButton("Update");
    update.addActionListener(this);
    update.setActionCommand("UPDATE");

    JPanel controls = new JPanel();
    controls.add(update);
    controls.setBorder(BorderFactory.createTitledBorder(
        "Choose Duke's Layer and Position"));
    return controls;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Color prev = labels.get(labels.size() - 1).getBackground();

    for (int i = labels.size() - 1; i > 0; --i) {
      labels.get(i).setBackground(labels.get(i - 1).getBackground());
      labels.get(i).validate();
      labels.get(i).repaint();
    }
    labels.get(0).setBackground(prev);
    labels.get(0).validate();
    labels.get(0).repaint();
  }

  private static void createAndShowGUI() {
    JFrame frame = new JFrame("LayeredPaneDemo2");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JComponent newContentPane = new LayeredPaneDemo2();
    newContentPane.setOpaque(true);
    frame.setContentPane(newContentPane);

    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        createAndShowGUI();
      }
    });
  }

}

class StackConstraints {
  public final int layer;
  public final Object layoutConstraints;

  public StackConstraints(int layer, Object layoutConstraints) {
    this.layer = layer;
    this.layoutConstraints = layoutConstraints;
  }
}

class LXLayeredPane extends JLayeredPane {
  @Override
  protected void addImpl(Component comp, Object constraints, int index) {
    int layer = 0;
    int pos = 0;
    Object constr = null;
    if (constraints instanceof StackConstraints) {
      layer = ((StackConstraints) constraints).layer;
      constr = ((StackConstraints) constraints).layoutConstraints;
    } else {
      layer = getLayer(comp);
      constr = constraints;
    }

    pos = insertIndexForLayer(layer, index);
    super.addImpl(comp, constr, pos);
    setLayer(comp, layer, pos);
    comp.validate();
    comp.repaint();
  }
}