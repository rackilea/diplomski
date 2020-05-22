public interface Handler<T> {
  public boolean shouldProcess(final T obj);
}

public class SimpleHandler implements Handler<Long> {
  @Override
  public boolean shouldProcess(final Long date) {
    ...
  }
}