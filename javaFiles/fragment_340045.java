public void actionPerformed(ActionEvent e) {
    panes.remove(playerStatPane);
    JComboBox cb = (JComboBox) e.getSource();
    String name = (String) cb.getSelectedItem();
    if (name.equals("Chip")) {
      playerStatPane = createStats(p1);
    } else if (name.equals("Dale")) {
      playerStatPane = createStats(p2);
    } else {
      playerStatPane = createStats(p3);
    }
    panes.add(playerStatPane);
  }