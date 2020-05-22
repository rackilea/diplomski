public static void main(String[] args) {

    JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());

    // == MigLayout Form ==
    JPanel panelCenter = new JPanel();
    panelCenter.setLayout(
                new MigLayout(
                        new LC().wrapAfter(4),
                        new AC().size(":80:", 0).size("115:115:115", 1, 2, 3).align("right", 0, 2),
                        new AC().size("19:19:19")
                ));
    panelCenter.setOpaque(false);

    panelCenter.add(new JLabel("Label1"));
    panelCenter.add(new JTextField(), new CC().growX());
    panelCenter.add(new JLabel("Label2"));
    panelCenter.add(new JTextField(), new CC().growX());
    panelCenter.add(new JLabel("Label3"));
    panelCenter.add(new JTextField(), new CC().growX());
    panelCenter.add(new JLabel("Label4"));
    panelCenter.add(new JTextField(), new CC().growX());
    panelCenter.add(new JLabel("Label5"));
    panelCenter.add(new JTextField(), new CC().growX());
    panelCenter.add(new JLabel("Label6"));
    panelCenter.add(new JTextField(), new CC().growX());

    frame.add(panelCenter, BorderLayout.CENTER);

    // == Buttons ==
    Box southPanel = Box.createHorizontalBox();
    southPanel.add(Box.createHorizontalGlue());
    southPanel.add(new JButton("Ok"));
    southPanel.add(new JButton("Cancel"));
    southPanel.add(Box.createHorizontalGlue());
    frame.add(southPanel, BorderLayout.SOUTH);

    frame.setVisible(true);
    frame.setSize(500, 150);
}