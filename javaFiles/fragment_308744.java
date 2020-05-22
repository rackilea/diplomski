new Thread(new Runnable() {
                @Override
                public void run() {
                     for (int i=0; i<5; i++) {
                         out.write("Count: " + i);
                         try {
                           Thread.sleep(2000);
                         } catch (InterruptedException e) {
                           e.printStackTrace();
                         }          
                      }
                     }
  }).start();