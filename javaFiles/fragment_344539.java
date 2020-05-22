private final LinkedBlockingQueue<Result> results = new LinkedBlockingQueue<Result>();

@Override
public void run() {
  while (!data.isEmpty()) {
    for (LocalTime dataTime : data) {
      if (new LocalTime().isAfter(dataTime)) {
        results.put(result);
      }
    }
  }
}

public Result takeResult() {
    return results.take(); 
}