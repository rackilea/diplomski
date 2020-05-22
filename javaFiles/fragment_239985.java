public class MyFrame extends JFrame {
  public MyFrame(){             
    this.setTitle("Hello");
    this.setSize(200, 200);
    this.setLocationRelativeTo(null);               

    MyPanel pan = new MyPanel();
    pan.setBackground(Color.ORANGE);        
    this.setContentPane(pan);               
    this.setVisible(true);
  }      

  public static void main(String[] args) {
        MyFrame f = new MyFrame();
    }
}