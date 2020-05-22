public void launchAsync(final String code) {
   new Thread() {
       public void run() {
           engine.eval(code);
       }
   }.run();
}