public void tick(){
  player.tick();

  long elapsed = (System.nanoTime()-startTime)/1000000;

  if(elapsed>1000)
  {
    nextDay(day, year, month);
    System.out.println("New day: " + day);
    startTime = System.nanoTime();
  }

  if(view1){
      runOnUiThread(new Runnable() {
        public void run(){  
           Overview_Viewupdate(); 
      }   
  });
 }

}