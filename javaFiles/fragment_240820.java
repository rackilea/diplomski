//1000 is the delay of each tick
 timer = new Timer(1000, new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             if(i == 2)
             {
                 timer.stop();
             }

            label.setBounds(71, 194, 125+(i*20), 125+(i*20));
             i++;
         }
      });
 timer.start();