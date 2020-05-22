// TIMER_DELAY could be 2000 if you want a 2 second delay
    new Timer(TIMER_DELAY, new ActionListener() {
        private int i = 0;
        private int j = 0; 

        @Override
        public void actionPerformed(ActionEvent e) {
            // MAX_ROWS is 9
            if (i == MAX_ROWS) {
                // we've iterated through the whole thing
                ((Timer) e.getSource()).stop();
            }
            if (j == MAX_ROWS) {
                // we've gone through all the columns
                i++;    // the next row
                j = 0;  // start at column 0
            }
            // TODO the code in the nested while loop.

            j++;
        }
    }).start();