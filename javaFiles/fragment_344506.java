public class StudentThread extends Thread {
  int ID;  
  private static int randomScore;
  private static final Object scoreLock = new Object();

  StudentThread(int i) {
     ID = i;
  }

  public void run() {
     changeRandomScore();

     System.out.println("in run");
  }
  public void changeRandomScore() {
     int tmp = (int) (Math.random()*1000);
     // no need to synchronize the random()-call, too.
     synchronized(scoreLock) {
        randomScore = tmp;
     }
  }
  public static void main(String args[]) throws Exception {
      for (int i = 1;i< 10 ;i++) 
      {
          StudentThread student = new StudentThread(5);

          student.start(); 
          Thread.sleep(100);
          synchronized(scoreLock) {
              System.out.println(randomScore);
          }
      }             
  }  
}