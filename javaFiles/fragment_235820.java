import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class AlternateIterator<T>
  implements Iterator<T>
{

  static <T> Iterable<T> alternate(Iterable<T> original)
  {
    return () -> new AlternateIterator<>(original.iterator());
  }

  private final Iterator<T> source;

  private boolean skipped;

  AlternateIterator(Iterator<T> source)
  {
    this.source = Objects.requireNonNull(source);
  }

  @Override
  public boolean hasNext()
  {
    if (!skipped) {
      if (source.hasNext())
        source.next();
      skipped = true;
    }
    return source.hasNext();
  }

  @Override
  public T next()
  {
    if (hasNext()) {
      skipped = false;
      return source.next();
    }
    throw new NoSuchElementException();
  }

  @Override
  public void remove()
  {
    source.remove();
  }

}