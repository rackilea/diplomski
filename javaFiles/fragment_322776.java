getContentPane().setBackground(colorArray[0]);
int delay = 1000; // for 1 second
Timer myTimer = new Timer(delay, new ActionListener() {

    int index = 0;
    public void actionPerformed(ActionEvent e) {
       index++;
       if (index >= colorArray.length) {
          ((Timer)e.getSource()).stop(); // stop the timer
       } else {
          getContentPane().setBackground(colorArray[index]);
       }
    }

});
myTimer.start();