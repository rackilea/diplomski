void init(){
   this.x = 10;
   this.y = 10;
}

public MemoryGame(){
   init();
}

public void actionPerformed(ActionEvent e) {
   if (exitButton == e.getSource()) {
      System.exit(0);
   }
   else if (replayButton == e.getSource()) {
      init();
   }
}