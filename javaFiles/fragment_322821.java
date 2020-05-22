public class InvaderPanel extends JPanel implements KeyListener,ActionListener {

  private int timealive; //in ms, max value 2147483647 --->3.5 weeks
  private Timer timer=new Timer(1000,this); // 1000ms = 1 second, but you 
                                            // can also set it to 30ms.
  /**
   * Create the panel.
   */
  public InvaderPanel() {
    addKeyListener(this);
    setFocusable(true);
    timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(playerdead){
      timer.stop();
      // here we can use timealive value
    } else {
      // timealive++; if you want to get the value in seconds
      //              in this case the timer delay must be 1000ms                  
      timealive += timer.getDelay(); // if you want to get the value in milliseconds
  }
}