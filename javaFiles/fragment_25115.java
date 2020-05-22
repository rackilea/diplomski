JFrame frame2 = new JFrame("Tauler Joc");
JPanel panell = new JPanel();
ImageIcon icon = new ImageIcon("king.jpg");
JButton jb= new JButton();
jb.setBounds(200,200,700,700);
panell.add(jb);

// Set image to size of JButton...
int offset = jb.getInsets().left;
jb.setIcon(resizeIcon(icon, jb.getWidth() - offset, jb.getHeight() - offset));

frame2.add(panell);
frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);