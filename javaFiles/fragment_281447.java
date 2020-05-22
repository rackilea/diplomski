public class MyUpdater extends Thread
{

long milis;
long nanos;

private ArrayList<Updatable> updatables;

public MyUpdater(long milis,long nanos)
      {
      super();

      this.milis=milis;
      this.nanos=nanos;

      updatables=new ArrayList<Updatable>();
      }

public void run()
      {

     runOnUiThread(new Runnable() {
     public void run() {

       long previousTime=System.nanoTime();

       while(true)
           { 
            sleep(milis,nanos);

            long now=System.nanoTime();
            long elapsedTime=previousTime-now;

            previousTime=now;

            update(elapsedTime);

           }

         }
        });
      }


public synchronized void addUpdatable(Updatable object)
      {
      updatables.add(object);

      }

public synchronized void removeUpdatable(Updatable object)
      {
      updatables.remove(object);

      }

private synchronized void update(long elapsedTimeNanos)
      {
      for(Updatable object: updatables)
        {
         object.onUpdate(elapsedTimeNanos);
        }

      }
}