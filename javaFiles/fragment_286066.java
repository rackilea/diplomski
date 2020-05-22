public class Test1 extends JFrame {

 public Test1(){
    TextPanel t = new TextPanel("Here's some text!");
    getContentPane().add(t, BorderLayout.CENTER);
    setMinimumSize(new Dimension(500, 500));

    //Various JFrame initialization stuff. 
    //repaint() makes sure the text is immediately visible.
    repaint();
    pack();
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  class TextPanel extends JPanel{
    private String text;

    public TextPanel(String t){
      text = t;
    }

    //Called by swing whenever this or a parent component calls repaint()
    @Override
    public void paint(Graphics g){
      g.setFont(new Font("Helvetica", Font.PLAIN, 13));
      g.drawString(text, 20, 30);

    }
  }

  public static void main(String[] args){
    new Test1(); 
  }
}