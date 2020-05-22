class GamePanel extends JPanel implements ActionListener{

 Timer timer=new Timer(1000, this);

 public GamePanel() {
   timer.start();// Start the timer here.
 }

 public void actionPerformed(ActionEvent ev){
    if(ev.getSource()==timer){
      repaint();// this will call at every 1 second
    }

}