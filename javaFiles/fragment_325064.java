public class MyBusinessClass {
  ExecutorService myExecutor = Executors.newCachedThreadPool(); //or whatever

  void a(){
    myExecutor.execute(new Runnable() {
        public void run() {
          doA();
        }
    });
  }    

  void b(){
    myExecutor.execute(new Runnable() {
        public void run() {
          doB();
        }
    });
  }    
}