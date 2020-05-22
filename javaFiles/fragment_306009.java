public class CounterTest  {
   public static final void main(String[] ignored)  {
      VeryImportantCounterPublic counter = new VeryImportantCounterPublic(3);
      counter.incrementCount();
      counter.incrementCount();
      counter.incrementCount();

      //Should not be able to do this!!
      //But it's a public field, so you can  :(
      counter.currentCount = -203847382;

      System.out.println("[PUBLIC] Current count is " + counter.getCurrentCount());


      VeryImportantCounterPrivate counter2 = new VeryImportantCounterPrivate(3);
      counter2.incrementCount();
      counter2.incrementCount();
      counter2.incrementCount();

      //Can't do this. Compiler error:
      //counter2.currentCount = -203847382;

      System.out.println("[PRIVATE] Current count is " + counter2.getCurrentCount());
   }
}