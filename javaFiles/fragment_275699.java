fun test() = TODO()

val exector:Executor = TODO()

exector.execute(::test)

//::test compile to java code as below:
Runnable task = new Runnable(){
   public void run(){
      test();
   }
};