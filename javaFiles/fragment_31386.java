public static void main( String [] args ) {
      JKFrame a = FrameA.createFrame(); // the same but splited like the following code 
 }


 class FrameA extends JFrame {
      // new method
      public static JFrame createFrame() {
            return new FrameA();  

      }
 }