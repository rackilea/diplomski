public class MyUI {

    //will switch to the gamepanel by removing all components from the frame and adding GamePanel
    public void switchToGamePanel() {
        frame.getContentPane().removeAll();

        GamePanel gp = new GamePanel();//keylistener/keyadapter was added to Jpanel here

        frame.add(gp);//add component. we could call requestFocusInWindow() after this but to be 98%  sure it works lets call after refreshing JFrame

        //refresh JFrame
        frame.pack();
        frame.revalidate();
        frame.repaint();

        gp.requestFocusInWindow();
    }

}
class GamePanel extends JPanel { 

      public GamePanel() {
          //initiate Jpanel and Keylistener/adapter
      }

}