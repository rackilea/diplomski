class SayHello extends TimerTask {
       public void run() {
           handler.post(new Runnable() {
               public void run() {
                   new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(100);
                                try {
                                    System.out.println("Hello test");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
               }
           });
       }
   }