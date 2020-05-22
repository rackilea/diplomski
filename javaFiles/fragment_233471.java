public void playerEvolution() {
  int delay = 500; // ms
  javax.swing.Timer timer = new javax.swing.Timer(delay , new ActionListener() {
     private int count = 0;
     private int maxCount = 5;

     @Override
     public void actionPerformed(ActionEvent evt) {
        if (count < maxCount * 2) {
           count++;
           // check if count is even to decide 
           // which image to use, and then
           // do your image swapping here
        } else {
           ((javax.swing.Timer)evt.getSource()).stop();
        }
     }
  });
}