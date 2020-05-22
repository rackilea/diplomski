public class Benim extends JFrame {
  Container contentArea = getContentPane ();

  public Benim(){
    super("Concentration");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setSize(800, 800);

    JButton start=new JButton("Start");
    JPanel pane=new JPanel();
    pane.add(start);
    add(pane);

    setVisible(true);
  }

  public static void main (String []args){
    new Benim();
  }
}