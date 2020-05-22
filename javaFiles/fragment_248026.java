public class MyGrid {

  public static void main (String[] args) {
    JFrame frame = new JFrame();
    Container container = frame.getContentPane();
    container.setLayout(new GridLayout(10,10));
    for ( int i =0; i < 100; i++ ){
      container.add( new JLabel( ""+i ) );
    }
    frame.setSize(500,500);
    frame.setVisible(true);
  }

}