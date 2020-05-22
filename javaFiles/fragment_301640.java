public class Test {
   private Process process;

   public void setProcess(Process process) {
      this.process = process;
   }

   ...

   public String triggerNew() {  
      process.blah();
   }
}