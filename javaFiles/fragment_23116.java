public class GridBagLayoutTagPanel extends JPanel {
  private final int NB_TAGS = 5;
  private final int NB_TAGVALUES = 50;

  public GridBagLayoutTagPanel() {
    setLayout(new GridLayout());

    ScrollablePanel pTags = new ScrollablePanel(new GridBagLayout());
    pTags.setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);
    pTags.setBackground(Color.ORANGE);
    GridBagConstraints c = new GridBagConstraints();
    c.ipadx = 5;
    c.ipady = 5;

    int rowIndex = 0;
    for (int i = 0; i < NB_TAGS; i++) {
      // add tag name
      JLabel lTagName = new JLabel(String.format("Tag %s:", i));
      lTagName.setFont(lTagName.getFont().deriveFont(Font.BOLD));
      c.fill = GridBagConstraints.NONE;
      c.gridx = 0;
      c.gridy = rowIndex++;
      c.weightx = 0; // keep minimum size of the cell containing the label when resizing
      c.weighty = 0;
      pTags.add(lTagName, c);

      // add tag values
      JPanel pTag = new JPanel(new BorderLayout());
      pTag.add(new JLabel("+"), BorderLayout.LINE_START); // label used to add new tags
      pTag.add(getWrapPanel(), BorderLayout.CENTER); // the list of tag values
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 1;
      c.weightx = 1; // fill horizontally
      c.weighty = 1;
      pTags.add(pTag, c);
   }

   JScrollPane sp = new JScrollPane(pTags);
   sp.setBorder(BorderFactory.createEmptyBorder());

   add(sp);
  }

  private JPanel getWrapPanel() {
    JPanel p = new JPanel(new WrapLayout(FlowLayout.LEFT, 5, 0));

    for (int i = 0; i < NB_TAGVALUES; i++) {
      p.add(new JLabel("t" + i));
    }

    p.setSize(400, 1);
    return p;
  }

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.getContentPane().add(new GridBagLayoutTagPanel());
    f.setSize(new Dimension(500, 300));
    f.setVisible(true);
  }
}