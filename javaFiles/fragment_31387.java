public static JFrame createFrame() {
            if( thatSpecialLogicSaysItIsTrialAndShouldPopUp() ) {
                  JFrame b = new FrameB();
                  b.setVisible( true );
                  JFrame c = new FrameC();
                  c.setVisible( true );
                  return new FrameA();

           } else {
            return new FrameA();
           }  

      }