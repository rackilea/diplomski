public class magnify extends JFrame{
    public JLabel IL;  // <-- THE RELEVANT CHANGE

    public final void showGUI(){
      IL = new JLabel(new ImageIcon());
      panel.add( IL );
      IL.setLocation( 0, 0 );

          int[] a= { 11, 20 };
      grabScreen g= new grabScreen( a, this );

    } 
//showGUI ends here

   public magnify(){  showGUI(); }

   public static void main( String[] args ){
    SwingUtilities.invokeLater( new Runnable(){ public void run(){ magnify rm= new magnify(); rm.setVisible(true); } });
   } 
//main ends here

}
 //magnify class ends here


//Second class grabScreen

public class grabScreen  implements Runnable{
   public grabScreen( int[] a, magnify myMagnify ){ // <-- CHANGE THIS
    try{
      myMagnify.IL.setIcon( new ImageIcon(ImageIO.read( new File( "sm.jpeg"  ) ) ) );
      // IL is the JLabel in the first class "magnify" inside a method "showGUI"
    }catch(Exception e ){  }

   }
} 
// grabScreen ends here