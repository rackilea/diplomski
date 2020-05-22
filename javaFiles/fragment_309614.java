class C {
   doSomeLogic(...) {...}
}


class A implements Job {
         public void execute(JobExecutionContext context) throws   JobExecutionException {
        // do A's stuff
        C c = new C();
        c.execute();  
  }


class B implements Job {
         public void execute(JobExecutionContext context) throws JobExecutionException {            
        C c = new C();
        c.execute();  
  }