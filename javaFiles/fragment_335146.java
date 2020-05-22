(new Thread(new Runnable()
       {
           @Override
           public void run()
           {

               for (int x=0; x<600; x++) {
                   try {
                       Thread.sleep(6);
                       runOnUiThread(new Runnable()  thread
                       {

                           @Override
                           public void run() {
                               YOU.setX((float) (YOU.getX() + run)); //pay attention here
                               YOU.setY((float) (YOU.getY() + rise));//pay attention here

                           }
                       });
                   } catch (InterruptedException e) {
                       // ooops
                   }
               }
           }
       })).start(); 

    }