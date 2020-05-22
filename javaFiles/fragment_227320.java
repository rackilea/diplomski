public class WhatEverServer {

    private UserInterface userInterface;
    [...]

    private static void createAndShowGUI() {

      if( GraphicsEnvironment.isHeadless() )
        logger.log( Level.FATAL, "This system seems to be 'headless'. Aborting now." ); 
      else {
        userInterface = UserInterface.getInstance();
        userInterface.createAndShowUI();
      }
    }

    public static void main( String[] args ) {

        // schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}


public class UserInterface {

    ...
    public void createAndShowUI() {

      // make sure we have nice window decorations.
      JFrame.setDefaultLookAndFeelDecorated(true);

      UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );

      // create and set up the window.
      JFrame frame = new JFrame( "Whatever Server" );
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // set UI components, i.e

      // set main menu bar
      frame.setJMenuBar( this.mainMenuBar );

      // set layout
      frame.getContentPane().setLayout( new BorderLayout() );

      // add UI components

      // display the window.
      frame.pack();
      frame.setVisible(true);
    }
}