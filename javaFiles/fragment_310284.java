for (int i = 10; i < 20; i++) {
           to.setValue(i);
           try {
              Thread.sleep(100);
           } catch (InterruptedException ex) {
              Logger.getLogger(DisplayJFrame.class.getName()).log(
                    Level.SEVERE, null, ex);
           }

           df.draw();
        }