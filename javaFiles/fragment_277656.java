while(true) {
        SwingUtilities.invokeLater(new Runnable{
            public void run() {
                textfield.setText(....);
            }
         });
         if(condition) break;
     }