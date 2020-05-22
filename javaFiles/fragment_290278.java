public class Excercise implements Runnable {
  enum ExcerciseType {
    WALKING,
    JOGGING,
    RUNNING
  };

  private final ExcerciseType excerciseType;
  public Thread thread;

  public Excercise(ExcerciseType type) {
    excerciseType = type;
  }

  public void start() {
    thread = new Thread(this);
    thread.start();
  }

  @Override
  public void run() {
    try {
      switch (excerciseType) {
        case WALKING:
          walk();
          break;
        case JOGGING:
          jog();
          break;
        default:
          running();
          break;
      } 
    } catch (InterruptedException e) {
      return;
    }
  }

  public void walk() throws InterruptedException {
    System.out.println("Started walking");
    Thread.sleep(3000);
    System.out.println("Done walking");
  }

  public void jog() throws InterruptedException {
    System.out.println("Started jogging");
    Thread.sleep(2000);
    System.out.println("Done jogging");
  }

  public void running() throws InterruptedException {
    System.out.println("Started running");
    Thread.sleep(1000);
    System.out.println("Done running");
  }

  public static void main(String[] args) {
    Excercise e1 = new Excercise(ExcerciseType.WALKING);
    e1.start();

    Excercise e2 = new Excercise(ExcerciseType.JOGGING);
    e2.start();

    Excercise e3 = new Excercise(ExcerciseType.RUNNING);
    e3.start();
  }
}