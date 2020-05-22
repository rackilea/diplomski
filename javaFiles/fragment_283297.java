public Gui(String title) {
   super(title);
   JPanel pane = new JPanel();
   setBounds(100, 100, 500, 500);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   Container con = this.getContentPane();
   pane.setBackground(new Color(0, 0, 0));
   con.add(pane);
   setVisible(true);
}