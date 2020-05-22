public Name<T> extends Activity{
  .
  .
  .
  private List<T> stuff;

  Runnable read = new Runnable(){
    public void run(){
      ...
      stuff = new ArrayList<T>(..);
    }
  };
  read.start();
}