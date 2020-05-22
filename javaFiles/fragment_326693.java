public class TextAreaTest extends KeyAdapter {

  private JFrame frame = new JFrame("Text Area Test");
  private JTextArea area = new JTextArea();

  public static void main(String[] args) {
    TextAreaTest test = new TextAreaTest();
    test.go();
  }

  private void go() {    
    area.addKeyListener(this);
    frame.getContentPane().add(area);
    frame.setVisible(true);
  }

  @Override
  public void keyPressed(KeyEvent evt) {
    if(evt.getKeyCode() == KeyEvent.VK_ENTER)
    {
         System.out.println("HERE"); //For sanity check.
         area.setText("BUTTON PRESSED");
         System.out.println("HERE AGAIN"); //For sanity check
    }
  }

}