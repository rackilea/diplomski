final Timer t = new Timer(10, new ActionListener(){
   public void actionPerformed(ActionEvent e){
      //do your updating of your variables here
      repaint();
      counter++;
      if(counter >= mouseX){
         t.stop();
      }
   }
});

t.start();