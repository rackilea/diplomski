class GUIClass extends JFrame{
 JLabel pathLabel;
 private void initialize() {
   frame = new JFrame();
   frame.setBounds(100, 100, 570, 393);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.getContentPane().setLayout(null);

   pathLabel = new JLabel("New label");
   pathLabel.setBounds(61, 296, 414, 15);
   frame.getContentPane().add(pathLabel);
}
void func(){
   pathLabel.setText("enter text here");
}