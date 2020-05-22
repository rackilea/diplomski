public static void main(String[]a) {
    JFrame fr = new JFrame();
    fr.setSize(new Dimension(1000,1000));
    fr.setLocationRelativeTo(null);
    JPanel topPanel = new JPanel(new GridBagLayout());
    Insets INSETS_0PX = new Insets(0,0,0,0);
    JLabel one = new JLabel("1");
    JLabel two = new JLabel("2");
    one.setBackground(Color.yellow);
    two.setBackground(Color.blue);

    JPanel myPanel = new JPanel(new GridBagLayout());
    myPanel.add(new JLabel("TITLE"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, INSETS_0PX, 0, 0));
    myPanel.add(new JTextArea(5,myPanel.WIDTH), new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
            GridBagConstraints.WEST, GridBagConstraints.BOTH, INSETS_0PX, 0, 0));

    JPanel threeCont = new JPanel(new GridBagLayout());
    threeCont.add(new JLabel("TITLE"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, INSETS_0PX, 0, 0));

    topPanel.add(myPanel, new GridBagConstraints(
        0, 0, 1, 1, 0.45, 0.0, GridBagConstraints.WEST,
        GridBagConstraints.HORIZONTAL, INSETS_0PX, 0, 0));

    topPanel.add(two, new GridBagConstraints(
        1, 0, 1, 1, 0.1, 0.0, GridBagConstraints.WEST,
        GridBagConstraints.BOTH, INSETS_0PX, 0, 0));

    topPanel.add(threeCont, new GridBagConstraints(
        2, 0, 1, 1, 0.45, 0.0, GridBagConstraints.EAST,
        GridBagConstraints.HORIZONTAL, INSETS_0PX, 0, 0));


    fr.add(topPanel);

    fr.setVisible(true);

    System.out.println("First Panel's Size : " + myPanel.getSize());
    System.out.println("Second Panel's Size : " +two.getSize());
    System.out.println("Third Panel's Size : " +threeCont.getSize());
}