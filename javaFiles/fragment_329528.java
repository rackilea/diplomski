// declaration: 
    static int changed = 0;

    // the timer:     
    Timer t = new Timer(2000, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
                // Change the colour here:
                if (changed == 0) {
                  // change the first one
                } else if (changed == 1) {
                  // change the second one
                } else if (changed == 2) {
                  // change the last one
                } else {
                  ((Timer) e.getSource()).stop();
                }
                changed ++;

          }
     });
     t.start();