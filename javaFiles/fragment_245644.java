class MyUI extends javax.swing.plaf.basic.BasicButtonUI {
  protected void  paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
    super.paintText(g,b,textRect,text);
  }
}

public class SampleForm extends JFrame implements ActionListener, ChangeListener{
  public SampleForm() {
    super("Window");
    fooButton = new JButton("jkljkl");
    fooButton.addActionListener(this);
    fooButton.addChangeListener(this);
    fooButton.addMouseListener(this);
    fooButton.setUI(new MyUI());