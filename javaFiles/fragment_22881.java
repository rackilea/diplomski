public interface ResultItem<T extends ResultItem<T>> {
    public int getConfidence();
    public boolean equals(T item);
    public T cloneWithConfidence(int newConfidence);
}

public class IntResult implements ResultItem<IntResult> {
  //...
}