public class Paddle {

     public void startMoveDown() {
         // here goes the logic, f.i. starting a timer
         // in the actionPerformed of that timer:
         ...  moveUnitDown(); 
     }
     public void stopMoveDown() {
        //... 
     }

     protected void moveUnitDown() {
         y+=unit;
         // ideally, have listeners and notify them the change of y
     } 
}

// in the view:
Action startMoveDown = new AbstractAction(){
    public void actionPerformed(ActionEvent e){
        player.startMoveDown();
   }
};

dp.getInputMap().put(KeyStroke.getKeyStroke("pressed DOWN"), "start move down");
dp.getActionMap().put("start move down", startMoveDown); 

// in the view:
Action stopMoveDown = new AbstractAction(){
    public void actionPerformed(ActionEvent e){
        player.stopMoveDown();
   }
};

dp.getInputMap().put(KeyStroke.getKeyStroke("released DOWN"), "stop move down");
dp.getActionMap().put("stop move down", stopMoveDown);