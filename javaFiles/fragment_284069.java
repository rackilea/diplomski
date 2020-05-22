class MyTask {
  int counter = 0;

  public void recurse() {
    counter++;
    if (whatever) { recurse(); }
  }

  public int getIterations() {
    return counter;
  }
}

public void run() {
  MyTask task = new MyTask();
  task.run();
  System.out.println("Task took "+task.getIterations()+" itertions.");
}