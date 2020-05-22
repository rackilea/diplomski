public void moveloop(){



       final double rise = Math.toDegrees(  Math.sin(toRadians(YOU.getRotation()))  )*SPEED;
       final double run  = Math.toDegrees(  Math.cos(toRadians(YOU.getRotation()))  )*SPEED;

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
                               YOU.setX((float) (YOU.getX() + run));
                               YOU.setY((float) (YOU.getY() + rise));

                           }
                       });
                   } catch (InterruptedException e) {
                       // ooops
                   }
               }
           }
       })).start(); 

    }