public void actionPerformed(ActionEvent e) {
      Object source = e.getSource();
      if (source == quit) {
         cards.show(c, "Introduction");
         for (int row = 0; row < 5; row++)
            for (int col = 0; col < 5; col++)
               buttons[row][col].setEnabled(true);
      } else { // don't forget this important else!
         for (int row = 0; row < 5; row++) { // use curly braces for *ALL*
                                             // loops/blocks
            for (int col = 0; col < 5; col++) {
               if (source == buttons[row][col]) {
                  questions.showTimer(row, col);
                  buttons[row][col].setEnabled(false);
               }
            }
         }

         boolean done = true;
         for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
               if (buttons[row][col].isEnabled()) {
                  done = false;
                  break;
               }
            }
         }
         if (done) {
            cards.show(c, "Game Over!");
         }
      }
   }