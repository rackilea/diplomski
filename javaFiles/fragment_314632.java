Container c = getContentPane();
 JPanel main = new JPanel();
 main.setOpaque(false); // This is very important.
 ImageIcon icon = new ImageIcon(getClass().getResource("signal.png"));
 main.add(new JLabel(icon));
 c.add(main);