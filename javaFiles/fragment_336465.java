JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    for ( int i = 0; i < 5; i++ ) {
        JComponent comp = new JPanel();
//      JComponent comp = new JButton("Button " + i);
        System.out.printf("Pref: %s Max: %s%n", comp.getPreferredSize(), comp.getMaximumSize());
        comp.setBackground(new Color(100 + i * 30, 0, 0));
        panel.add(comp);
    }