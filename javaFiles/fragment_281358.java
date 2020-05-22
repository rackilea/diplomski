class MyClass implements Runnable {
   private final Integer value;

   MyClass() {
      new Thread(this);
      int i = 0;
      value = Integer.valueOf(20 / i);
   }

   @Override
   public void run() {
      System.out.println(value.intValue());
   }
}