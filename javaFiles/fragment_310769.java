JOptionPane pane = new JOptionPane();
JPanel panel = new JPanel();
JLabel label = new JLabel("Hello World!");
panel.add(label); // You can add any components you want to this panel

 pane.showOptionDialog(null, panel, "JOptionPane Title", 
     JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
     null, new Object[]{}, null);