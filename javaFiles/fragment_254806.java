public class ArrayPopulator implements Runnable {

  private Object[] array;
  private int minIndex;
  private int maxIndex;

  public ArrayPopulator(Object[] array, int minIndex, int maxIndex) {
    //assignments
  }

  public void run() {
    for (int i = minIndex; i <= maxIndex; i++) {
      //you get the idea
    }
  }
}


Thread thread1 = new Thread(new ArrayPopulator(array, 0, 19));
Thread thread1 = new Thread(new ArrayPopulator(array, 20, 39));