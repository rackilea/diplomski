ActionListener animate = e -> {
    game.oneFrame();
    panel.repaint();  
};
timer = new Timer(50, animate); 
timer.start(); 

public void oneFrame(){
   //update what is needed for one "frame"
}