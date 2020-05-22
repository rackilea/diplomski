[[main]]
CountDownLatch startSignal = new CountDownLatch(1);
for(int i = 0; i< 10; i++)
{
 Thread th = new MyAddingThread();
 th.Start();
}
startSignal.countdown();


[[on the thread]]    
public class MyAddingThread extends Thread{
 public void run()
 {
   startSignal.await();
   hash.Add(rn.nextInt,rn.nextInt);
 }
}