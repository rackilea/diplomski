public class Data {
  private int id;
  private final String name;

  Data(String name) { this.name = name; }
  public String getName() { return name; }  
}

public class FutureData extends Data {
  private int id;
  private final Future<String> nameFuture;

  FutureData(Future<String> nameFuture) { this.nameFuture = nameFuture; }
  @Override public String getName() { return nameFuture.get(); }  
}

public interface MyService {
  public Data fetchData(int id);
}

public class SyncMyService implements MyService {
  private SyncDao syncDao;
  public Data fetchData(int id) {
    return syncDao.getData(id);
  }
}

public class AsyncMyService implements MyService {
  private static final ExecutorService executor = 
    Executors.newFixedThreadPool(10);

  public FutureData fetchData(final int id) {
    Future<String> future = executor.submit(new Callable<String>() {
      public String call() {
        String name;
        //some long computation that computes the name using the id given
        return name;
      }
    });
    FutureData futureData = new FutureData(future);
    return futureData;
  }
}