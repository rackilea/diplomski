//The variable "taxa" is the amount of times that i want it to do the task
    javax.swing.Timer time1 = new javax.swing.Timer(taxa, new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                genReelNumbers();

            }
            });
//starts the timer
         time1.start();


//New timertask
            TimerTask tt = new TimerTask() {

            @Override
            public void run() {
//stops the timer
            time1.stop();
            label_2.setVisible(false);
            label_1.setVisible(true);
            verificarodas();
            }
            };
            Timer time = new Timer(true);

    // the 2000 is how long i want to do the task's
   //if i changed to 3000 it would take 3 seconds (remember it has to be a value on miliseconds) to do the 15 times, and soo on

            time.schedule(tt, 2000);