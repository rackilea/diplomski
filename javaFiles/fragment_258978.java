ReentrantLock lock = new ReentrantLock();


Thread eventMusic = new Thread(new EventMusic());
lock.lock();
... check different conditions ... (every 0.02s)
if everything is ok  -> eventMusic.start();
lock.unlock();


public class EventMusic implements Runnable{
@Override
public void run() {

    try {
        lock.lock();
        Player p = new Player(new FileInputStream(getClass().getClassLoader().getResource("res/nameSong.mp3").getPath()));
        p.play();
    } catch (JavaLayerException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();}
    finally{
       lock.unlock();
    }

 }
}