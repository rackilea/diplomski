public Test() {
    JLabel t=new JLabel();
    this.setLayout(new BorderLayout());
    t.setIcon(new ImageIcon("Path to image goes here"));
    this.add(t);
    this.pack();
    this.setVisible(true);  
}