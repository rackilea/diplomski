JFrame frame = new JFrame("test");
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
JPanel panel = new JPanel(new GridLayout(4,4,4,4));

for(int i=0 ; i<16 ; i++){
    JButton btn = new JButton(String.valueOf(i));
    btn.setPreferredSize(new Dimension(40, 40));
    panel.add(btn);
}
frame.setContentPane(panel);
frame.pack();
frame.setVisible(true);