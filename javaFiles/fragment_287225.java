Thread t = new Thread() {
 @Override
 public void run() {
 try {
    while (!isInterrupted()) {
         Thread.sleep(100);
         runOnUiThread(new Runnable() {
         @Override
         public void run(){Render();}});}
         }catch (InterruptedException e) {}}};

 t.start();
}

public void Render()
{
    if(checkCollision(ball))
    {
      //Do something
    }
}