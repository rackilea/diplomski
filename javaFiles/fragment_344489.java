public ReadTask implements Runnable
{
  private Teacher teacher;

  public ReadTask(Teacher teacher)
  {
    this.teacher = teacher;
  }

  public void run()
  {
    teacher.readBook();
  }
}

public WriteTask implements Runnable
{
  private Teacher teacher;

  public WriteTask (Teacher teacher)
  {
    this.teacher = teacher;
  }

  public void run()
  {
    teacher.writeToBook();
  }
}