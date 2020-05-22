class Sequence extends Thread{

    private AtomicInteger integer; //shared
    boolean flag=false; //local

    public Sequence(AtomicInteger integer) {
      this.integer=integer;
    }