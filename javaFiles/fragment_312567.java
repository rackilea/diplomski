class CounterTask1 extends SwingWorker<Integer, Integer> {
   private String text;

   public CounterTask1(String text) {
      this.text = text;
   }

   protected Integer doInBackground() throws Exception {

      String one = text;
      String two = "Thanks !";
      String Addst = one + two;
      System.out.println("printing in Task" + Addst);
      return 0;
   }