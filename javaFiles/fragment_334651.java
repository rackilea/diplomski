public class JTALineNum extends JFrame{
 JTextArea jta = null;
 JButton button = null;

 public JTALineNum(){
  jta = new JTextArea();
  button = new JButton("Hit Me");

  button.addActionListener(new ButtonListener());

  add(jta, BorderLayout.CENTER);
  add(button, BorderLayout.SOUTH);
  setSize(200,200);
  setVisible(true);
 }

 private class ButtonListener implements ActionListener{

  public void actionPerformed(ActionEvent e) {
   String text = jta.getText();
   String[] tokens = text.split("\n");
   for(String i : tokens){
    System.out.println("Token:: " + i);
   }
  }
 }

 public static void main(String args[]){
  JTALineNum app = new JTALineNum();
  app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}