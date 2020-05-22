public class myGUI extends JFrame implements ActionListener, MouseListener{

 private JLabel x1,x2,x3;

 public myGUI(){
   // do constructor stuff
   x1 = new JLabel("x1");
   x2 = new JLabel("x2");
   x3 = new JLabel("x3");

  x1.addMouseListener(this);
  x2.addMouseListener(this);
  x3.addMouseListener(this);

 }

  // other methods

  @Override
  public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(x1)){
          // do x1 stuff
        }
        else if(e.getSource().equals(x2)){
          // do x2 stuff
        }
        else if(e.getSource().equals(x3)){
          // do x3 stuff
        }

  }

}