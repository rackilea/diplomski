public class BlockingSortOnTakeQueue<E extends Comparable<E>> implements Queue<E> {
  ...
  @Override
  public synchronized E remove() {
    Collections.sort(m_list);
    return m_list.remove(0);
  }
}