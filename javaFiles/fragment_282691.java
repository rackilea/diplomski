public class HistoryCallable implements Callable<HistoryResult> {


  private long totalItems;
  private volatile long itemsProcessed;

  @Override
  public HistoryResult call() {
   // do a lot of stuff
   // after each item:
   itemsProcessed++;
  }

  public long getItemsProcessed() {
    return itemsProcessed;
  }

  public long getTotalItems() {
    return totalItems;
  }
}



public class PersonHistoryBuilder {
  private Person person;
  private HistoryCallable callable;

  public Person getPerson() {
    return person;
  }

  public float getProgressPercent() {
    return (100.0f * callable.getItemsProcessed()) / callable.getTotalItems();
  }

}