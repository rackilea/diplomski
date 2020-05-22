import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Iterables;

public class RoundRobinIterable<T> {
  private final Iterator<T> elements;

  public RoundRobinIterable(final List<T> elements) {
    List<T> copyOfElements = new ArrayList<>(elements);
    this.elements = Iterables.cycle(copyOfElements).iterator();
  }

  public synchronized T getNext() {
    return this.elements.next();;
  }
}